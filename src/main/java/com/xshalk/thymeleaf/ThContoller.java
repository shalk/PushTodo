package com.xshalk.thymeleaf;

import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ThContoller {
    
    @Value("${hello.msg: 'Shalk' }")
    private String msg;

    @RequestMapping("/")
    public String hello(Map<String, Object> model){
        String welcome = "Hello ," + msg;
        model.put("welcome", welcome);
        return "test";
    }
    
    @RequestMapping("/list")
    public String list(Map<String, Object> model) {
        model.put("user", new User("lilei", "mail@163.com", Calendar.getInstance()));
        return "list";
    }

}
