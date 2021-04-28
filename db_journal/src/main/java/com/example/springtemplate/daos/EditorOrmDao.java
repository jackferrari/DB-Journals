package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Editor;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.ArticleRepository;
import com.example.springtemplate.repositories.EditorRepository;
import com.example.springtemplate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EditorOrmDao {
    @Autowired
    EditorRepository editorRepository;
    ArticleRepository articleRepository;
    UserRepository userRepository;

    @PostMapping("/api/editors")
    public Editor createEditor(@RequestBody Editor editor) {
        return editorRepository.save(editor);
    }
    
    @GetMapping("/api/editors")
    public List<Editor> findAllEditors() {
        return editorRepository.findAllEditors();
    }
    
    @GetMapping("/api/editors/{editorId}")
    public Editor findEditorById(
            @PathVariable("editorId") Integer id) {
        return editorRepository.findEditorById(id);
    }

    @GetMapping("/api/editors/{editorId}/articles")
    public List<Article> findArticlesOfEditors(@PathVariable("editorId") Integer id) {
        return articleRepository.findArticlesOfEditors(id);
    }

    @GetMapping("/api/editors/{editorId}/users")
    public List<User> findUsersOfEditors(@PathVariable("editorId") Integer id) {
        return userRepository.findEditorUsers(id);
    }
    
    @PutMapping("/api/editors/{editorId}")
    public Editor updateEditor(
            @PathVariable("editorId") Integer id,
            @RequestBody Editor editorUpdates) {
        Editor editor = editorRepository.findEditorById(id);
        editor.setRole(editorUpdates.getRole());
        editor.setUserId(editorUpdates.getUserId());
        return editorRepository.save(editor);
    }
    
    @DeleteMapping("/api/editors/{editorId}")
    public void deleteEditor(
            @PathVariable("editorId") Integer id) {
        editorRepository.deleteById(id);
    }
}
