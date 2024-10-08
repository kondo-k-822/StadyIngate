package com.example.todo.controller;

//import com.example.todo.service.point.PointEntity;
import com.example.todo.dto.ShowListDTO;
import com.example.todo.form.Form;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
/** ② Lombokの@RequiredArgsConstructorを使用する
 *     build.gradle等の設定が必要 **/
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TodoContoroller {

    /** ③ @RequiredArgsConstructorを使用することで外部オブジェクトを下記のように宣言できる
     *     @RequiredArgsConstructorを使用する場合はfinalにすること **/
    private final TodoService service;

    @GetMapping
    public String tasks(Model model) {

        /** ①現行のままだと外部オブジェクトを使用する際毎回インスタンス化が必要
         *    Lombokを使用することで解消する **/
//        TodoService service = new TodoService();
        String test = service.StadyService();
        model.addAttribute("serviceString", test);
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        Form form = new Form("","","","");
        model.addAttribute("form", form);
        return "form";
    }

    @PostMapping
    public String insert(@Validated Form form,
                         BindingResult bindingResult,
                         Model model){
        if(bindingResult.hasErrors()){
            return showCreationForm(form,model);
        }
        service.StadyInsertDB(form);
        return "redirect:/tasks";
    }

    public String showCreationForm(@ModelAttribute Form form, Model model){
        return "/form";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<ShowListDTO> formlist = service.StadySelectDB();
        model.addAttribute("formList", formlist);
        return "/list";
    }
    /** 課題用 @GetMapping**/
    
    /** 課題用 @PostMapping**/
}
