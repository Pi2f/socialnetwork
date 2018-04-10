package com.polytech.web;

import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;

import java.util.ArrayList;
import java.util.LinkedList;
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
