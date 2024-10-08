package com.example.todo.service;

//import com.example.todo.controller.Point.PointDTO;
//import com.example.todo.repository.point.PointTaskRpository;
import com.example.todo.dto.ShowListDTO;
import com.example.todo.form.Form;
import com.example.todo.repository.TodoRpository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRpository todoRpository;

    public String StadyService(){
        String stadyName = "Serviceアノテーション";
        return stadyName;
    }

    public void StadyInsertDB(Form form){
        todoRpository.insertMA001(form);
    }

    /** 課題用 UPDATE用のSQLを呼び出す **/

    public List<ShowListDTO> StadySelectDB(){
        return todoRpository.select();
    }

}
