package com.example.demoresttemplate.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demoresttemplate.infra.ApiResponse;
import com.example.demoresttemplate.model.UserDTO;

public interface UserOperation {

    @GetMapping(value = "/users")
    ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception;
}
