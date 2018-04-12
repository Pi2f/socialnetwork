package com.polytech.web;

import com.polytech.services.FeedService;
import com.polytech.services.Story;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedRestController {
    private FeedService feedService;

    public FeedRestController(FeedService feedService) {
        this.feedService = feedService;
    }

    @RequestMapping(value="/rest/feed", method=RequestMethod.GET)
    public List<Story> stories(){
        List<Story> stories = feedService.fetchAll();
        return stories;
    }
}
