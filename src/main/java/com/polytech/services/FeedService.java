package com.polytech.services;

import com.polytech.persistence.StoryRepository;

import java.util.List;

public class FeedService {
    private StoryRepository stories;
    public FeedService(StoryRepository stories) {
        this.stories = stories;
    }

    public List<Story> fetchAll(){
        return stories.findAll();
    }
}
