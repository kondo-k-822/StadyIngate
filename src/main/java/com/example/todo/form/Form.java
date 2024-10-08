package com.example.todo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record Form(
        @NotBlank
        String username,
        @NotBlank
        @Size(max = 256, message = "256文字以内で入力してください")
        String userid,
        @NotBlank
        String password,
        @NotBlank
        @Pattern(regexp = "TODO|DOING|DONE", message = "TODO,DOING,DONEのいずれかを選択してください")
        String status
) {

}
