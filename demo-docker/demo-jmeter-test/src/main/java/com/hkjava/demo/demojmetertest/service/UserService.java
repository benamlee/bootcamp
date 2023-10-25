package com.hkjava.demo.demojmetertest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demojmetertest.entity.User;
import com.hkjava.demo.demojmetertest.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  
  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User create(User user) {
    return userRepository.save(user);
  }

}
