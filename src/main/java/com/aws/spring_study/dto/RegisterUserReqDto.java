package com.aws.spring_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserReqDto {
    private String username;
    private String name;
    private String phone;
}
