package com.hkjava.demo.demojmetertest.mapper;

import com.hkjava.demo.demojmetertest.dto.UserDTO;
import com.hkjava.demo.demojmetertest.entity.User;

public class UserMapper {

  public static User map(UserDTO userDTO) {
    return User.builder() //
        .userId(userDTO.getUserId()) //
        .userName(userDTO.getName()) //
        .age(userDTO.getAge()) //
        .build();
  }
  
}
