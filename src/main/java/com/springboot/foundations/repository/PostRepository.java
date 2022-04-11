package com.springboot.foundations.repository;

import com.springboot.foundations.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
