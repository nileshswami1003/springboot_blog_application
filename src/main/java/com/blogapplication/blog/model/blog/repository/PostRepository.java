package com.blogapplication.blog.model.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
