package com.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	@Value("${boot.name}")
	private String name;
    @RequestMapping("/boot/hello")
    public String hello(){
    	return "hello boot"+name;
    }
    
}
