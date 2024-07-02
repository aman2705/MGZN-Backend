package com.mgzn.backend.model.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TradingIdea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("title")
    @Column(unique = true, nullable = false)
    private String title;

    @JsonProperty("content")
    @Column(length = 1000)
    private String content;

    @JsonProperty("author")
    private String author;

    @JsonProperty("tags")
    @ElementCollection
    private List<String> tags;

    @JsonProperty("engagement")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engagement_id")
    private Engagement engagement;
}
