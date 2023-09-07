package com.aws.spring_study.controller;

import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.repository.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserMappers userMappers;

    @CrossOrigin    // 허용경로 어노테이션
    @PostMapping("/user")            // 어노테이션 사용으로 json 또는 데이터타입으로 받겠다는거
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserReqDto registerUserReqDto) {

        Integer count = userMappers.saveUser(registerUserReqDto);

        return ResponseEntity.ok().body(count);
    }
}