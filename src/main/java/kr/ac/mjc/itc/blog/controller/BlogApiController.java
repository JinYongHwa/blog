package kr.ac.mjc.itc.blog.controller;

import kr.ac.mjc.itc.blog.domain.Article;
import kr.ac.mjc.itc.blog.dto.AddArticleRquest;
import kr.ac.mjc.itc.blog.dto.ArticleResponse;
import kr.ac.mjc.itc.blog.dto.UpdateArticleRequest;
import kr.ac.mjc.itc.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequiredArgsConstructor
public class BlogApiController {
    private final BlogService blogService;

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){

        List<ArticleResponse> articles=blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

//        List<Article> blogList=blogService.findAll();
//
//        List<ArticleResponse> articles=new ArrayList<>();
//        for(int i=0;i<blogList.size();i++){
//            articles.add(new ArticleResponse(blogList.get(i)));
//        }
        return ResponseEntity.ok()
                .body(articles);
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRquest request){

        Article savedArticle=blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,@RequestBody UpdateArticleRequest request){
        Article updatedArticle=blogService.update(id,request);
        return ResponseEntity.ok()
                .body(updatedArticle);
    }



    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article= blogService.findById(id);
        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }




}
