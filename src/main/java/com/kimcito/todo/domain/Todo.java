package com.kimcito.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "todo")
@Entity
public class Todo {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String text;

private String due_day;

private String due_time;

private boolean reminder;

    @Builder
    public Todo(Long id, String text, String due_day, String due_time, boolean reminder) {
        this.id = id;
        this.text = text;
        this.due_day = due_day;
        this.due_time = due_time;
        this.reminder = reminder;

    }


}
