package com.aws.spring_study.controller;

import com.aws.spring_study.dto.JsonTestDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutController {

    // Post랑 동일함
    @PutMapping("/put/json")
    public Object json(@RequestBody JsonTestDto jsonTestDto) {
        System.out.println(jsonTestDto);
        return null;
    }
}