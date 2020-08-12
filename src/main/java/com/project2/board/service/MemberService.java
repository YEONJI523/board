package com.project2.board.service;

import com.project2.board.dto.Member;

public interface MemberService {
    Member findByUserId(String user_id);
    Member findByUsername(String username);
    Member findByUserPasswd(String password);
}
