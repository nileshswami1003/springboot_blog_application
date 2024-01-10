package com.blogapplication.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogapplication.blog.model.Post;
import com.blogapplication.blog.service.PostService;

@Controller
public class PostController {

	@Autowired
    private PostService postService;
	
//	public PostController(PostService postService) {
//		this.postService = postService;
//	}

	@GetMapping("/")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }
	
	@GetMapping("/post/{id}")
    public String getPostById(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post";
    }
	
	@GetMapping("/newpost")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "newpost";
    }
	
	@PostMapping("/newpost")
    public String savePost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/";
    }
	
	@GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "updatepost";
    }
	
	@PostMapping("/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post updatedPost) {
        Post existingPost = postService.getPostById(id);
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        postService.savePost(existingPost);
        return "redirect:/";
    }
	
	@GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}
