package com.kimcito.todo.repository;

import com.kimcito.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    public Todo findTodoById(Long id);
}
