package com.polytech.web;

import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FeedController {
    private FeedService feedService;
    private PublicationService publicationService;

    public FeedController(FeedService feedService, PublicationService publicationService) {
        this.feedService = feedService;
        this.publicationService = publicationService;
    }

    @RequestMapping(value="/share", method=RequestMethod.POST)
    public String post(String content){
        publicationService.share(new Story(content));
        return "redirect:/feed";
    }

    @RequestMapping(value="/feed", method=RequestMethod.GET)
    public String feed(Model model){
        List<Story> stories = feedService.fetchAll();
        model.addAttribute("stories",stories);
        return "feed";
    }

    @RequestMapping(value="/feed/{content}", method = RequestMethod.GET)
    public String fetchOnePost(@PathVariable String content, Model model){
        publicationService.share(new Story(content));
        return "redirect:/feed";
    }
}
