package com.project2.board.dto;

import lombok.Data;

/**
 * name: Member
 * create_user:hansnet003
 * create_date:2020-08-10
 */

@Data
public class Member {
    private int id;
    private String nickname;
    private String blog_name;
    private String username;
    private String domain;
    private String user_id;
    private String password;
    private int role_name;//0이면 일반회원 1이면 관리자.

    private MemberRole role;
}
