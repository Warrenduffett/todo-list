package com.kimcito.todo.dto;

import com.kimcito.todo.domain.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class TodoPostResponseDto {

    private Long id;
    private String text;

    private String due_day;

    private String due_time;

    private boolean reminder;

    public TodoPostResponseDto(Todo entity) {
        this.id = entity.getId();
        this.text = entity.getText();
        this.due_day = entity.getDue_day();
        this.due_time = entity.getDue_time();
        this.reminder = entity.isReminder();
    }
}
