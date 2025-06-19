package com.tenco.blog.controller;

import com.tenco.blog.model.Board;
import com.tenco.blog.repository.BoardNativeRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // IoC 대상 - 싱글톤 패턴으로 관리된다
public class BoardController {

    private BoardNativeRepository boardNativeRepository;
    public BoardController(BoardNativeRepository boardNativeRepository) {
        this.boardNativeRepository = boardNativeRepository;
    }

    // board/1
    // *상세보기 화면 요청
    @GetMapping("/board/{id}")
    public String detail(@PathVariable(name="id") Long id,
                         HttpServletRequest request) {
        // URL 에서 받은 id 값을 사용해서 특정 게시글 상세보기 조회
        // 실제로는 이 id 값으로 DB에 있는 게시글 조회 하고 mustache 파일로 데이터를 내려주어야 함(Model)
        Board board = boardNativeRepository.findById(id);
        request.setAttribute("board",board);

        return "board/detail";
    }




    @PostMapping("/board/save")
    // username, title, content <--- DTO / 기본 DT setting
    // form 태그에서 넘어오는 데이터 받기
    // form tag, name 속성에 key value mapping
    public String save(@RequestParam("username") String username,
                       @RequestParam("title") String title,
                       @RequestParam("content") String content) {
        System.out.println("username = " + username);
        System.out.println("title = " + title);
        System.out.println("content = " + content);

        boardNativeRepository.save(username,title,content);

        return "redirect:/";
    }


    @GetMapping({"/", "/index"})
//    public String index() {
//    public String index(Model model) {
    public String index(HttpServletRequest request) {

        // DB 접근해서 select 결과값을 받아서 mustache file에 data binding 처리해야한다
        List<Board> boardList = boardNativeRepository.findAll();
        // 뷰에 데이터를 전달 > Model 사용가능, but
        request.setAttribute("boardList", boardList);

        return "index";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {

        return "board/save-form";
    }


}
