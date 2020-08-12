package com.project2.board.mapper;

import com.project2.board.dto.Auth;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    Auth findByAuth(int user_id);//ROLE_USER or ROLE_ADMIN
}
