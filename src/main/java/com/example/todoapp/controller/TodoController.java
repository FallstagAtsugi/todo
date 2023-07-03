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
//        List<Todo> list = todoMapper.selectAll();
        List<Todo> list = todoMapper.selectIncomplete();
        List<Todo> doneList = todoMapper.selectComplete();
        model.addAttribute("todos", list);
        model.addAttribute("doneTodos",doneList);

        return "index";
    }

    @RequestMapping(value = "/add")
    public String add(Todo todo){
        todoMapper.add(todo);
        return "redirect:/";
    }

    @RequestMapping(value = "/update")
    public String update(Todo todo){
        todoMapper.update(todo);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String delete(){
        todoMapper.delete();
        return "redirect:/";
    }
}
