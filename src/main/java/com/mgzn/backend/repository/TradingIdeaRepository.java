package com.mgzn.backend.repository;

import com.mgzn.backend.model.post.TradingIdea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingIdeaRepository extends CrudRepository<TradingIdea, Long> {
    TradingIdea findByTitle(String title);
}
