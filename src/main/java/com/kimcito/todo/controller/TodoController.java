package com.kimcito.todo.controller;

import com.kimcito.todo.domain.Todo;
import com.kimcito.todo.dto.TodoPostResponseDto;
import com.kimcito.todo.dto.TodoSaveRequestDto;
import com.kimcito.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoPostResponseDto Create(@RequestBody TodoSaveRequestDto requestDto) {
        Long id = todoService.save(requestDto);
        return todoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @GetMapping
    public List<Todo> viewTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public TodoPostResponseDto findByTodoId(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PutMapping("/{id}")
    public Todo toggleReminder(@PathVariable Long id) {
        return todoService.updateTodo(id);
    }

}
