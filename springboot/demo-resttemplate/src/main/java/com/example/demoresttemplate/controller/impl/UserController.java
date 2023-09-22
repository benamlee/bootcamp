package com.example.demoresttemplate.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoresttemplate.controller.UserOperation;
import com.example.demoresttemplate.infra.ApiResponse;
import com.example.demoresttemplate.infra.Code;
import com.example.demoresttemplate.mapper.UserMapper;
import com.example.demoresttemplate.model.User;
import com.example.demoresttemplate.model.UserDTO;
import com.example.demoresttemplate.service.UserService;

@RestController // Controller + ResponseBody
@RequestMapping("/api/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception {
    List<User> users = userService.findUsers();

    // Conversion (user -> userDTO)
    List<UserDTO> userDTOs = users.stream() //
        .map(user -> UserMapper.map(user)) //
        .collect(Collectors.toList());

    ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder() //
        // .status(Code.OK) //
        .ok() //
        .data(userDTOs) //
        .build();
    return ResponseEntity.ok().body(response);
  }
}
