package com.example.todoapp.controller;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoMapper todoMapper;

    @RequestMapping(value = "/")
    public String index(Model model){
        List<Todo> list = todoMapper.selectAll();
        model.addAttribute("todos", list);
        return "index";
    }
}
