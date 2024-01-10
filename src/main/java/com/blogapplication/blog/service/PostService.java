package com.blogapplication.blog.service;

import java.util.List;

import com.blogapplication.blog.model.Post;

public interface PostService {

	List<Post> getAllPosts();
    Post getPostById(Long id);
    void savePost(Post post);
    void deletePost(Long id);
    
}
