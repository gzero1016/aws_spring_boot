package com.aws.spring_study.repository;

import com.aws.spring_study.dto.ModifyUserReqDto;
import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMappers {
    public Integer saveUser(RegisterUserReqDto registerUserReqDto); //xml에서 구현할거임 (추상메소드)
    public List<User> getUserListAll();
    public Integer updateUserList(ModifyUserReqDto modifyUserReqDto);
    public Integer deleteUserList(int userId);
}
