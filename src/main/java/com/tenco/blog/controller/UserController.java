package com.tenco.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    //요청돼 오는 주소 /join-form
    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    //반환값이 뷰 이름이 됨 (뷰 리졸버가 실제 파일 경로를 찾아 감)
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    //http://localhost:8080/user/update-form
    @GetMapping("/user/update-form")
    public String updateForm() {
        return "user/update-form";
    }

    /* redirect: "스프링에서 접두사를 사용하면 다른 URL로 리다이렉트 된다
    즉, 리다이렉트한다는 것은 뷰를 렌더링하지 않고
    브라우저가 재요청을 하게끔 유도하는 것이다
     */
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
