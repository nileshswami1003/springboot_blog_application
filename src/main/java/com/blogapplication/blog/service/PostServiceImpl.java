package com.blogapplication.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blog.model.Post;
import com.blogapplication.blog.model.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
    private PostRepository postRepository;

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public void savePost(Post post) {
		postRepository.save(post);
		
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
		
	}

}
