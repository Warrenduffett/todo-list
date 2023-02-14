package com.kimcito.todo.dto;

import com.kimcito.todo.domain.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoSaveRequestDto {

    private String text;

    private String due_day;

    private String due_time;

    private boolean reminder;

    @Builder
    public TodoSaveRequestDto(String text, String day, String time, boolean reminder) {
        this.text = text;
        this.due_day = day;
        this.due_time = time;
        this.reminder = reminder;
    }

    public Todo toEntity() {
        return Todo.builder()
                .text(text)
                .due_day(due_day)
                .due_time(due_time)
                .reminder(reminder)
                .build();
    }
}
