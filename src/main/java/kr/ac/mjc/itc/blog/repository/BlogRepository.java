package kr.ac.mjc.itc.blog.repository;

import kr.ac.mjc.itc.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
