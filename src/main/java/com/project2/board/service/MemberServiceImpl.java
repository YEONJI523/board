package com.project2.board.service;

import com.project2.board.dto.Member;
import com.project2.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * name: MemberServiceImpl
 * create_user:hansnet003
 * create_date:2020-08-12
 */
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Member findByUserId(String user_id) {
        return memberMapper.findByUserId(user_id);
    }

    @Override
    public Member findByUsername(String username) {
        return memberMapper.findByUsername(username);
    }

    @Override
    public Member findByUserPasswd(String password) {
        return null;
    }
}
