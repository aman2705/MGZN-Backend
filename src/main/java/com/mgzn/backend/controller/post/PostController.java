package com.mgzn.backend.controller.post;

import com.mgzn.backend.model.post.TradingIdea;
import com.mgzn.backend.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    /*TODO - One for adding Post and another for getting Post*/

    @Autowired
    private PostService postService;

    // Endpoint for adding a post
    @PostMapping
    public ResponseEntity<TradingIdea> addPost(@RequestBody TradingIdea tradingIdea) {
        TradingIdea createdPost = postService.addPost(tradingIdea);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // Endpoint for getting a post by title
    @GetMapping("/{title}")
    public ResponseEntity<TradingIdea> getPost(@PathVariable String title) {
        TradingIdea post = postService.getPostByTitle(title);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint for getting all posts
    @GetMapping
    public ResponseEntity<List<TradingIdea>> getAllPosts() {
        List<TradingIdea> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
