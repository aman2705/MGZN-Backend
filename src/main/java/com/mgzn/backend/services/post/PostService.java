package com.mgzn.backend.services.post;

import com.mgzn.backend.model.post.TradingIdea;
import com.mgzn.backend.repository.TradingIdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private TradingIdeaRepository tradingIdeaRepository;

    public TradingIdea addPost(TradingIdea tradingIdea) {
        return tradingIdeaRepository.save(tradingIdea);
    }

    public TradingIdea getPostByTitle(String title) {
        return tradingIdeaRepository.findByTitle(title);
    }

    public List<TradingIdea> getAllPosts() {
        return (List<TradingIdea>) tradingIdeaRepository.findAll();
    }
}
