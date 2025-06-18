package com.tenco.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //IoC 대상 -> 싱글톤패턴 관리
public class BoardController {

            /*
           prefix: /templates/
           return: index
           suffix: /mustache
           src/main/resources/teamplates/index.mustache
           */

    @GetMapping({"/", "/index"})
    public String index() {


        return "index";
    }

    @GetMapping("/board/save-form") //하이픈(-)이 권장사항
    public String saveForm() {
        return "board/save-form";
    }

    /* 상세보기 화면 요청
    board/1
    URL에서 받은 id값을 사용해 특정 게시글 상세보기
    실제로는 이 id 값으로 db에 있는 게시글을 조회하고
    머스테치 파일로 데이터를 내려줘야 한다. (Model)
    */
    @GetMapping("/board/{id}")
    public String detail(@PathVariable(name = "id")Integer id) {

        return "board/detail";
    }



}
