package com.aws.spring_study.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // 자동으로 json으로 변환해줌
// restController : 데이터만 리턴
// Controller : 서버 사이드 랜더링, 데이터 리턴도 가능 (Responsebody와 함께사용해야함)
// 세션: 개개인마다 사물함을 주는거 (무상태는 사물함을 주지않아서 이전 요청기록이 없음)
public class ReqStudyController {

    @GetMapping("/test/get")
    public Object get() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", "김준일");
        dataMap.put("email", "aaa@gmail.com");
        return dataMap;
    }

    @PostMapping("/test/post")
    public Object post() {
        return "POST";
    }

    @PutMapping("/test/put")
    public Object put() {
        return "PUT";
    }

    @DeleteMapping("/test/delete")
    public Object delete() {
        return "DELETE";
    }
}