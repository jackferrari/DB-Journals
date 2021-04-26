package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Author;
import com.example.springtemplate.models.Editor;
import com.example.springtemplate.models.Journal;
import com.example.springtemplate.repositories.ArticleRepository;

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

    @GetMapping("/api/authors/findbyaid/{articleId}")
    public Author findAuthorById(
            @PathVariable("articleId") Integer id) {
        return articleRepository.findAuthorById(id);
    }

    @GetMapping("/api/editors/findbyaid/{articleId}")
    public Editor findEditorById(
            @PathVariable("articleId") Integer id) {
        return articleRepository.findEditorById(id);
    }

    @GetMapping("/api/journals/findbyaid/{articleId}")
    public Journal findJournalById(
            @PathVariable("articleId") Integer id) {
        return articleRepository.findJournalById(id);
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
