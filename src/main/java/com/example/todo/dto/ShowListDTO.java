package com.example.todo.dto;

import java.sql.Timestamp;

/**ma001データ画面表示用DTO**/
public record ShowListDTO(
        int id,
        String userid,
        String username,
        String password,
        String status,
        Timestamp updatedata
) {

}
