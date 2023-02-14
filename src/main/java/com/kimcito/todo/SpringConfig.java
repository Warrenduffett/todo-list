package com.kimcito.todo;

import com.kimcito.todo.repository.TodoRepository;
import com.kimcito.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final TodoRepository todoRepository;

    @Autowired
    public SpringConfig(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Bean
    public TodoService todoService() {
        return new TodoService(todoRepository);
    }


}
