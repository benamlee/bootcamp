package com.example.demoresttemplate.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.demoresttemplate.exception.JPHException;
import com.example.demoresttemplate.infra.BusinessException;
import com.example.demoresttemplate.infra.Code;
import com.example.demoresttemplate.infra.Protocol;
import com.example.demoresttemplate.model.User;
import com.example.demoresttemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService { // Bean

    @Autowired
    private RestTemplate restTemplate; // find from Context

    @Value(value = "${api.jsonplaceholder.domain}") // 要同yml的link對到一模一樣!!!!!!!!!!!!!!
    private String jphDomain; // jsonplaceholder.typicode.com // find from yml

    @Value(value = "${api.jsonplaceholder.endpoints.user}") // 要同yml的link對到一模一樣!!!!!!!!!!!!!!
    private String userEndpoint; // find from yml

    @Override
    public List<User> findUsers() throws BusinessException {
        String url = UriComponentsBuilder.newInstance() //
                .scheme(Protocol.HTTPS.name()) //
                .host(jphDomain) //
                .path(userEndpoint) //
                .toUriString();

        System.out.println("url=" + url);
        // Invoke API + Jaskson Deserialization (JSON -> Object)
        // try {
        User[] users = restTemplate.getForObject(url, User[].class);
        // return Arrays.asList(users);
        // } catch (RestClientException e) {
        throw new JPHException(Code.JPH_NOTFOUND);
        // }
    }

}
