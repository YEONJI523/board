package com.project2.board.service;

import com.project2.board.dto.Member;
import com.project2.board.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


/**
 * name: MemberService
 * create_user:hansnet003
 * create_date:2020-08-10
 */

@Slf4j
@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    MemberMapper memberMapper;

    private static final String ROLE_PREFIX= "ROLE_";

    @PostConstruct
    private void created(){
        log.debug("체크로그인");
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        log.info("loadUserByUsername user id {} ", user_id);

        Member member= memberMapper.findByUserId(user_id); //DB에서 확인
        log.debug("member", member.toString());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX+ member.getRole().name()));
        //권한조회시에 role을 조회하므로 prefix로 붙여준다.??DB작업??
        log.debug("권한체크:", grantedAuthorities.toString());
        return new User(member.getUser_id(), member.getPassword(), grantedAuthorities);
    }

}
