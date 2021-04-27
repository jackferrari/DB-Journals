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
    @Query(value = "SELECT * FROM articles WHERE id=:authorId",
            nativeQuery = true)
    public List<Article> findArticlesOfAuthors(@Param("authorId") Integer id);
    @Query(value = "SELECT * FROM users WHERE id=:authorId",
            nativeQuery = true)
    public List<User> findAuthorUsers(@Param("authorId") Integer id);
}
