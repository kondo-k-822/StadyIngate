package com.example.todo.repository;
import com.example.todo.dto.ShowListDTO;
import com.example.todo.form.Form;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

/**CRUD処理を記述するためのインターフェース
 * ここではSQLを使用するためのアノテーションを使用してデータのCLUDを学習する**/
@Mapper
public interface TodoRpository {
    @Select("SELECT id,userid,username,password,status,updatedata FROM spring_stadyDB.ma001")
    List<ShowListDTO> select();

    /**INSERT用のアノテーション
     * テーブルma001に対して入力したデータを追加する **/
    @Insert(""" 
            INSERT INTO spring_stadyDB.ma001 (userid,username,password,status,updatedata)
            VALUES (#{f.userid},#{f.username},#{f.password},#{f.status},now())""")
    /**@Paramは@INSERT内にパラメータを渡すためのアノテーション **/
    void insertMA001(@Param("f") Form form);

    /**Q UPDATE用のアノテーションを使用して更新処理の実装（フロント・バックエンドどちらも）を行ってください。
     * 1.このインターフェースでは@UPDATEを使用すること（修正ファイル：TodoRpository）
     * 2.list.htmlのIDに更新画面用リンクを張り画面へ遷移させること（修正ファイル：list.html, TodoContoroller.java）
     * 3.遷移先のHTMLはform.htmlを複製して更新用に書き換えること（修正ファイル：form.html, TodoContoroller.java, TodoService.java）
    **/
}