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

    @Query(value = "select * from editors, ( Select editor from articles where id=:articleId) " +
            "as wanted_editor where editors.id = wanted_editor.editor;",
            nativeQuery = true)
    public Editor findEditorByArticleId(@Param("articleId") Integer id);

}
