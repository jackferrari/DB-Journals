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

    @Query(value = "select * from authors, ( Select author from articles where id=:articleId) " +
            "as wanted_author where authors.id = wanted_author.author;",
            nativeQuery = true)
    public List<Author> findAuthorByArticleId(@Param("articleId") Integer id);

    @Query(value = "SELECT * FROM authors WHERE user_id=:userId",
            nativeQuery = true)
    public List<Author> findAuthorsForUser(@Param("userId") Integer id);
}
