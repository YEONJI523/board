package com.project2.board.controller;

import com.project2.board.service.MyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * name: MemberController
 * create_user:hansnet003
 * create_date:2020-08-10
 */
@Slf4j
@Controller
public class MemberController {

    @Autowired
    MyUserService myUserService;

    @GetMapping("/login")
    public ModelAndView login(Model model, String error, String logout) throws Exception{
        if (error != null)
            model.addAttribute("error", "아이디 또는 패스워드가 잘못 되었습니다.");
        if (logout != null)
            model.addAttribute("message", "로그아웃 되었습니다.");

        return new ModelAndView("/member/login");
    }
    @GetMapping("/main")
    public String main(){
        return "/board/main";
    }

}
