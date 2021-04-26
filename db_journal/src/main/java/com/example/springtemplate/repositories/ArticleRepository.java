package com.example.springtemplate.repositories;

import com.example.springtemplate.models.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository
        extends CrudRepository<Article, Integer> {
    @Query(value = "SELECT * FROM articles",
            nativeQuery = true)
    public List<Article> findAllArticles();
    @Query(value = "SELECT * FROM articles WHERE id=:articleId",
            nativeQuery = true)
    public Article findArticleById(@Param("articleId") Integer id);

    public Author findAuthorById(@Param("articleId") Integer id);

    public Editor findEditorById(@Param("articleId") Integer id);

    public Journal findJournalById(@Param("articleId") Integer id);
}
