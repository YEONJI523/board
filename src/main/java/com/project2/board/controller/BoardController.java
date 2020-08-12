/*
package com.project2.board.controller;

import com.project2.board.dto.BoardDto;
import com.project2.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/main")
    public String main() throws Exception{
        return "/board/main";
    }

    @RequestMapping("/list")
    public ModelAndView boardList() throws Exception{
        log.debug("list");
        ModelAndView mv = new ModelAndView("/board/list");
        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);

        return mv;
    }

    @GetMapping("/openWrite")
    public String openBoardWrite() throws Exception{
        return "/board/write";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(BoardDto board) throws Exception{
        boardService.insertBoard(board);
        return "redirect:/board/list";
    }

    @RequestMapping("/openBoardDetail")
    public ModelAndView openBoardDetail(@RequestParam int no) throws Exception{
        ModelAndView mv = new ModelAndView("/board/detail");
        BoardDto board = boardService.selectBoardDetail(no);
        mv.addObject("board", board);

        return mv;
    }

    @PostMapping("/updateBoard")
    public String updateBoard(BoardDto board) throws Exception{
        boardService.updateBoard(board);
        return "redirect:/board/list";
    }
    @PostMapping("/deleteBoard")
    public String deleteBoard(@RequestParam int id) throws Exception{
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }


}
*/
