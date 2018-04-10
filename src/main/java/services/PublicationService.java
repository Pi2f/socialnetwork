package services;

import persistence.StoryRepository;

public class PublicationService {
    StoryRepository stories;

    public PublicationService(StoryRepository stories) {
        this.stories = stories;
    }

    public void post(Story story){
        stories.save(story);
    }
}
