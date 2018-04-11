package com.polytech.services;

import com.polytech.persistence.StoryRepository;

public class PublicationService {
    StoryRepository stories;

    public PublicationService(StoryRepository stories) {
        this.stories = stories;
    }

    public void share(Story story){
        stories.save(story);
    }
}
