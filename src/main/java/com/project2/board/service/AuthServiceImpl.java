package com.project2.board.service;

import com.project2.board.dto.Auth;
import com.project2.board.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * name: MemberServiceImpl
 * create_user:hansnet003
 * create_date:2020-08-12
 */
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthMapper authMapper;

    @Override
    public Auth findByAuth(int user_id) {
        return authMapper.findByAuth(user_id);
    }
}
