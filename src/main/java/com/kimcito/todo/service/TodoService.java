package com.kimcito.todo.service;

import com.kimcito.todo.domain.Todo;
import com.kimcito.todo.dto.TodoPostResponseDto;
import com.kimcito.todo.dto.TodoSaveRequestDto;
import com.kimcito.todo.repository.TodoRepository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public Long save(TodoSaveRequestDto dto) {
        return todoRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<Todo> getTodoList() {

        List<Todo> todoList = todoRepository.findAll();

        if (CollectionUtils.isEmpty(todoList)) {
            System.out.println("not found");
        } else {
            System.out.println(todoList.get(0).getText());
        }
        return todoList;
    }

    public TodoPostResponseDto findById(Long id) {

        Todo entity = todoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not found task. Id =" + id));

        return new TodoPostResponseDto(entity);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(Long id) {
        Todo todo = todoRepository.findTodoById(id);

        Todo updatedTodo = Todo.builder()
                .id(id)
                .text(todo.getText())
                .due_day(todo.getDue_day())
                .due_time(todo.getDue_time())
                .reminder(!todo.isReminder()).build();

        todoRepository.save(updatedTodo);

        return updatedTodo;
    }
}
