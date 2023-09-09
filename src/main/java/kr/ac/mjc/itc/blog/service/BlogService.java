package kr.ac.mjc.itc.blog.service;

import kr.ac.mjc.itc.blog.domain.Article;
import kr.ac.mjc.itc.blog.dto.AddArticleRquest;
import kr.ac.mjc.itc.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Article> articles(){
        return blogRepository.findAll();
    }
    public Article save(AddArticleRquest request){
        return blogRepository.save(request.toEntity());
    }
}
