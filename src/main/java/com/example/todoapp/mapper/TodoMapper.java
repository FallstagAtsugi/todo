package com.example.todoapp.mapper;

import com.example.todoapp.entity.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    public List<Todo> selectAll();

}
