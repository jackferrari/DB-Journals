package com.example.springtemplate.daos;

import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.Editor;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.AuthorRepository;
import com.example.springtemplate.repositories.EditorRepository;
import com.example.springtemplate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserOrmDao {
    @Autowired
    UserRepository userRepository;
    AuthorRepository authorRepository;
    EditorRepository editorRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
    
    @GetMapping("/api/users/{userId}")
    public User findUserById(
            @PathVariable("userId") Integer id) {
        return userRepository.findUserById(id);
    }

    @GetMapping("/api/users/{userId}/authors")
    public List<Author> findAuthorsOfUsers(
            @PathVariable("userId") Integer id) {
        return authorRepository.findAuthorsForUser(id);
    }

    @GetMapping("/api/users/{userId}/editors")
    public List<Editor> findEditorsOfUsers(
            @PathVariable("userId") Integer id) {
        return editorRepository.findEditorsForUser(id);
    }
    
    @PutMapping("/api/users/{userId}")
    public User updateUser(
            @PathVariable("userId") Integer id,
            @RequestBody User userUpdates) {
        User user = userRepository.findUserById(id);
        user.setFirstName(userUpdates.getFirstName());
        user.setLastName(userUpdates.getLastName());
        user.setUsername(userUpdates.getUsername());
        user.setPassword(userUpdates.getPassword());
        user.setEmail(userUpdates.getEmail());
        user.setDateOfBirth(userUpdates.getDateOfBirth());
        return userRepository.save(user);
    }
    
    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(
            @PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
    }
}
