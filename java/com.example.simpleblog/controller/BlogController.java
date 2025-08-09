package com.example.simpleblog.controller;

import com.example.simpleblog.entity.Post;
import com.example.simpleblog.entity.User;
import com.example.simpleblog.service.PostService;
import com.example.simpleblog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {

    private final UserService userService;
    private final PostService postService;

    public BlogController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    // Home page — shows all posts
    @GetMapping({"/", "/home"})
    public String home(Model model, HttpSession session) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        model.addAttribute("username", session.getAttribute("username"));
        return "home";
    }

    // Registration page
    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               Model model) {
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        User user = new User(username, password, email);
        userService.register(user);
        model.addAttribute("message", "Registration successful! Please login.");
        return "register";
    }

    // Login page
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model,
                            HttpSession session) {
        if (userService.authenticate(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    // Logout handler
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // Show form to add a post
    @GetMapping("/add-post")
    public String showAddPost(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        return "add-post";
    }

    // Handle new post submission
    @PostMapping("/add-post")
    public String addPost(@RequestParam String title,
                          @RequestParam String content,
                          HttpSession session,
                          Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        Post post = new Post(title, content, username);
        postService.addPost(post);
        return "redirect:/home";
    }
}
