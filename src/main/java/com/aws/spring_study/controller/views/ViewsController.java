package com.aws.spring_study.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewsController {

    @ResponseBody   //응답을 데이터
    @GetMapping("/student/register")
    public String studentRegister(Model model) {
        model.addAttribute("title", "학생 등록");
        return "student_register";
    }

}