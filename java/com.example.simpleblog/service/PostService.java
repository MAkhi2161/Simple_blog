package com.example.simpleblog.service;

import com.example.simpleblog.entity.Post;
import com.example.simpleblog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get posts by username
    public List<Post> getPostsByUser(String username) {
        return postRepository.findByUsername(username);
    }

    // Add new post
    public void addPost(Post post) {
        postRepository.save(post);
    }
}
