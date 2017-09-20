package com.xshalk.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/todo/view")
public class TodoController {
    
    
    @Autowired
    private TodoRepository repository;
    
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        List<Todo> todos = (List<Todo>) this.repository.findAll();
        mav.setViewName("todo/index");
        mav.addObject("todos", todos);
        return mav;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam("id") Integer id) {
        Todo todo = this.repository.findOne(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("todo/detail");
        mav.addObject("todo", todo);
        return mav;
    }

}
