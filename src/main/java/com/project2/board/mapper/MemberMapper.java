package com.project2.board.mapper;

import com.project2.board.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member findByUserId(String user_id);
    Member findByUsername(String username);
    Member findByUserPasswd(String password);
}
