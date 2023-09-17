package kr.ac.mjc.itc.blog.service;

import jakarta.transaction.Transactional;
import kr.ac.mjc.itc.blog.domain.Article;
import kr.ac.mjc.itc.blog.dto.AddArticleRquest;
import kr.ac.mjc.itc.blog.dto.UpdateArticleRequest;
import kr.ac.mjc.itc.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;
    //전체 블로그글 가져오기
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    //블로그글 저장
    public Article save(AddArticleRquest request){
        return blogRepository.save(request.toEntity());
    }

    //블로그글 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    //블로그글 업데이트
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article=blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found :"+id));

        article.update(request.getTitle(),request.getContent());
        return article;
    }


    //블로그 글 한개 가져오기
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }

}
