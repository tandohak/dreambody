package com.dreambody.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *   @author 홍윤표
 *   @description 테스트를 위한 Hello 컨트롤러 생성.
 *   @date 2020.06.16 10:33:14
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
