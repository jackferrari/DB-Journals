package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.Editor;
import com.example.springtemplate.models.Journal;
import com.example.springtemplate.repositories.ArticleRepository;

import com.example.springtemplate.repositories.AuthorRepository;
import com.example.springtemplate.repositories.EditorRepository;
import com.example.springtemplate.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ArticleOrmDao {
    @Autowired
    ArticleRepository articleRepository;
    AuthorRepository authorRepository;
    EditorRepository editorRepository;
    JournalRepository journalRepository;

    @PostMapping("/api/articles")
    public Article createUser(@RequestBody Article article) {
        return articleRepository.save(article);
    }
    
    @GetMapping("/api/articles")
    public List<Article> findAllArticles() {
        return articleRepository.findAllArticles();
    }
    
    @GetMapping("/api/articles/{articleId}")
    public Article findArticleById(
            @PathVariable("articleId") Integer id) {
        return articleRepository.findArticleById(id);
    }

    @GetMapping("/api/articles/{articleId}/authors")
    public Author findAuthorById(
            @PathVariable("articleId") Integer id) {
        return authorRepository.findAuthorById(id);
    }

    @GetMapping("/api/articles/{articleId}/editors")
    public Editor findEditorById(
            @PathVariable("articleId") Integer id) {
        return editorRepository.findEditorById(id);
    }

    @GetMapping("/api/articles/{articleId}/journals")
    public Journal findJournalByArticleId(
            @PathVariable("articleId") Integer id) {
        return journalRepository.findJournalByArticleId(id);
    }
    
    @PutMapping("/api/articles/{articleId}")
    public Article updateArticle(
            @PathVariable("articleId") Integer id,
            @RequestBody Article articleUpdates) {
        Article article = articleRepository.findArticleById(id);
        article.setTitle(articleUpdates.getTitle());
        article.setContent(articleUpdates.getContent());
        article.setBibliography(articleUpdates.getBibliography());
        article.setAuthor(articleUpdates.getAuthor());
        article.setEditor(articleUpdates.getEditor());
        article.setJournal(articleUpdates.getJournal());
        return articleRepository.save(article);
    }
    
    @DeleteMapping("/api/articles/{articleId}")
    public void deleteArticle(
            @PathVariable("articleId") Integer id) {
        articleRepository.deleteById(id);
    }
}
