package com.blogapplication.blog.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String title;
    private String content;
    private Date createdAt = new Date();
    
    
	public Post() {
		super();
	}


	public Post(Long id, String title, String content, Date createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
    
    
}
