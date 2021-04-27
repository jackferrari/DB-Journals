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
    @Query(value = "SELECT * FROM editors WHERE id=:editorId",
            nativeQuery = true)
    public List<Article> findArticlesOfEditors(@Param("editorId") Integer id);
    @Query(value = "SELECT * FROM users WHERE id=:editorId",
            nativeQuery = true)
    public List<User> findEditorUsers(@Param("editorId") Integer id);
}
