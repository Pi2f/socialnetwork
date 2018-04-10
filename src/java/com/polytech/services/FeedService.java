package com.polytech.services;

import persistence.StoryRepository;

import java.util.List;

public class FeedService {
    StoryRepository stories;
    public FeedService(StoryRepository stories) {
        this.stories = stories;
    }

    public List<Story> feed(){
        return stories.getStories();
    }
}
