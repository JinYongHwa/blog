package kr.ac.mjc.itc.blog.dto;


import kr.ac.mjc.itc.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRquest {

    private String title;
    private String content;
    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content).build();
    }
}
