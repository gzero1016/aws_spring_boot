package com.aws.spring_study.controller;

import com.aws.spring_study.dto.JsonTestDto;
import com.aws.spring_study.dto.xWwwTestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/post/xwww")
    //xWwwFormUrlEncoded:
    public Object xWwwFormUrlEncoded(xWwwTestDto xWwwTestDto) {
        System.out.println(xWwwTestDto);
        return null;
    }

    // json 형태로 받으려면 @RequestBody가 무조건 있어야 json으로 받을 수 있음 (json 은 Post, Put 두곳에서만 사용)
    @PostMapping("/post/json")
    public Object json(@RequestBody JsonTestDto jsonTestDto) {
        System.out.println(jsonTestDto);
        return null;
    }
}