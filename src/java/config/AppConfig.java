package config;

import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.web.FeedController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import persistence.MemoryStoryRepository;
import persistence.StoryRepository;

@Configuration
public class AppConfig {

    @Bean
    public StoryRepository storyRepository(){
        return new MemoryStoryRepository();
    }

    @Bean
    public FeedService feedService(){
        return new FeedService(storyRepository());
    }

    @Bean
    public PublicationService publicationService(){
        return new PublicationService(storyRepository());
    }

    @Bean
    public FeedController feedController(){
        return new FeedController(feedService(),publicationService());
    }
}
