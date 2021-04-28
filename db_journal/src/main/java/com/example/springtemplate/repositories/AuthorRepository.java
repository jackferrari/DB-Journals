package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository
        extends CrudRepository<Author, Integer> {
    @Query(value = "SELECT * FROM authors",
            nativeQuery = true)
    public List<Author> findAllAuthors();
    @Query(value = "SELECT * FROM authors WHERE id=:authorId",
            nativeQuery = true)
    public Author findAuthorById(@Param("authorId") Integer id);

    @Query(value = "SELECT authors.primary_topic, authors.user_id FROM authors, articles WHERE id:=articleId " +
            "AND users.id=authors.user_id",
            nativeQuery = true)
    public Author findAuthorByArticleId(@Param("articleId") Integer id);

    @Query(value = "SELECT * FROM authors WHERE user_id=:userId",
            nativeQuery = true)
    public List<Author> findAuthorsForUser(@Param("userId") Integer id);
}
