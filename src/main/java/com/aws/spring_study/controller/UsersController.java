package com.aws.spring_study.controller;

import com.aws.spring_study.dto.ModifyUserReqDto;
import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import com.aws.spring_study.repository.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserMappers userMappers;

    @CrossOrigin    // 허용경로 어노테이션
    @PostMapping("/user")            // 어노테이션 사용으로 json 또는 데이터타입으로 받겠다는거
    public ResponseEntity<Integer> registerUser(@RequestBody RegisterUserReqDto registerUserReqDto) {

        Integer count = userMappers.saveUser(registerUserReqDto);

        return ResponseEntity.ok().body(count);
    }

    @CrossOrigin
    @GetMapping("/user/list")
    public ResponseEntity<List<User>> userListAll() {
        return ResponseEntity.ok().body(userMappers.getUserListAll());
    }

    @CrossOrigin
    @PutMapping("/users/{userId}")
    public ResponseEntity<Integer> modifyUser(
            @PathVariable int userId,
            @RequestBody ModifyUserReqDto modifyUserReqDto) {

        Integer count = userMappers.updateUserList(modifyUserReqDto);

        return ResponseEntity.ok().body(count);
    }

    @CrossOrigin
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable int userId) {

        Integer count = userMappers.deleteUserList(userId);

        return ResponseEntity.ok().body(count);
    }
}