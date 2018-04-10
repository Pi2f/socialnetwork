package web;

import services.FeedService;
import services.PublicationService;
import services.Story;

import java.util.List;

public class FeedController {
    private FeedService feedService;
    private PublicationService publicationService;

    public FeedController(FeedService feedService, PublicationService publicationService) {
        this.feedService = feedService;
        this.publicationService = publicationService;
    }

    public void post(Story story){
        publicationService.post(story);
    }

    public List<Story> feed(){
        return feedService.feed();
    }
}
