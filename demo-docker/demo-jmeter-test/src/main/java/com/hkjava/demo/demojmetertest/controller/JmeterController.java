package com.hkjava.demo.demojmetertest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demojmetertest.dto.UserDTO;
import com.hkjava.demo.demojmetertest.entity.User;
import com.hkjava.demo.demojmetertest.mapper.UserMapper;
import com.hkjava.demo.demojmetertest.service.UserService;

@RestController
@RequestMapping(value = "/v1")
public class JmeterController {

  public static int counter = 0;

  @Autowired
  private UserService userService;

  @GetMapping(value = "/jmeter")
  public String jmeterTest() {
    System.out.println(++counter);
    return "current count=" + String.valueOf(counter);
  }

  @GetMapping(value = "/users")
  public List<User> getUsers() {
    return userService.findAll();
  }

  @PostMapping(value = "/user")
  public User create(@RequestBody UserDTO userDTO) {
    User user = UserMapper.map(userDTO);
    return userService.create(user);
  }

}