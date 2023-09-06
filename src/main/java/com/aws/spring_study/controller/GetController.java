package com.aws.spring_study.controller;

import com.aws.spring_study.dto.ParamsTestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    // get요청은 params만 사용
    @GetMapping("/get/params/1")
    // @RequestParam : params 받는거 (변수명이랑 파라미터명이 동일하면은 () 안에 받을 변수명 안적어도됨)
    // @RequestParam 을 쓸때 주의사항은 필수로 값이 있어야 된다 없으면 400코드뜸
    // 안에 값이 있는지 아닌지 모를때는 어노테이션사용하지 않음! null 처리를 위해 int 말고 Integer를 사용하자!
    public Object paramsTest1(String name, Integer age) {
        System.out.println(name);
        System.out.println(age);
        return null;
    }

    @GetMapping("/get/params/2")
    public Object paramsTest2(ParamsTestDto paramsTestDto) {
        System.out.println(paramsTestDto);
        return null;
    }

    //PathVariable: 어디에서나 사용가능함
    @GetMapping("/get/{id}")
    public Object pathVariable(@PathVariable("id") int id) {
        System.out.println(id);
        return null;
    }
}