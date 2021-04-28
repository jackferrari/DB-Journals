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

    @Query(value = "SELECT users.first_name, users.last_name, users.username, users.username," +
            "users.password, users.email, users.date_of_birth FROM users, authors WHERE id=:authorId",
            nativeQuery = true)
    public List<User> findAuthorUsers(@Param("authorId") Integer id);

    @Query(value = "select * from users, ( Select user_id from editors where id=:editorId) " +
            "as wanted_user where users.id = wanted_user.user_id;",
            nativeQuery = true)
    public List<User> findEditorUsers(@Param("editorId") Integer id);
}
