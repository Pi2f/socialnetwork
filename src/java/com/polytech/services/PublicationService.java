package com.polytech.services;

import persistence.StoryRepository;

import java.util.List;

public class PublicationService {
    StoryRepository stories;

    public PublicationService(StoryRepository stories) {
        this.stories = stories;
    }

    public void post(Story story){
        stories.getStories().add(story);
    }
}
