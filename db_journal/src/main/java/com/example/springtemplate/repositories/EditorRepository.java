package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Editor;
import com.example.springtemplate.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EditorRepository
        extends CrudRepository<Editor, Integer> {
    @Query(value = "SELECT * FROM editors",
            nativeQuery = true)
    public List<Editor> findAllEditors();
    @Query(value = "SELECT * FROM editors WHERE id=:editorId",
            nativeQuery = true)
    public Editor findEditorById(@Param("editorId") Integer id);

    @Query(value = "SELECT * FROM editors WHERE user_id=:userId",
            nativeQuery = true)
    public List<Editor> findEditorsForUser(@Param("userId") Integer id);

    @Query(value = "SELECT editors.role, editors.user_id FROM" +
            " editors, articles WHERE articles.id=? AND id:=articleId",
            nativeQuery = true)
    public Editor findEditorByArticleId(@Param("articleId") Integer id);

}
