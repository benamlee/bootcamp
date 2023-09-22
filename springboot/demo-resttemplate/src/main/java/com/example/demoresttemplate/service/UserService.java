package com.example.demoresttemplate.service;

import java.util.List;
import com.example.demoresttemplate.infra.BusinessException;
import com.example.demoresttemplate.model.User;

public interface UserService {

    public List<User> findUsers() throws BusinessException;
}
