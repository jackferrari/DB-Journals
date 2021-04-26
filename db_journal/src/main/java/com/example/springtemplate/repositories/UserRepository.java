package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.Editor;
import com.example.springtemplate.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository
        extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM users",
            nativeQuery = true)
    public List<User> findAllUsers();
    @Query(value = "SELECT * FROM users WHERE id=:userId",
            nativeQuery = true)
    public User findUserById(@Param("userId") Integer id);
    @Query(value = "SELECT * FROM authors WHERE user_id=:userId",
            nativeQuery = true)
    public List<Author> findAuthorsForUser(@Param("userId") Integer id);
    @Query(value = "SELECT * FROM editors WHERE user_id=:userId",
            nativeQuery = true)
    public List<Editor> findEditorsForUser(@Param("userId") Integer id);
}
