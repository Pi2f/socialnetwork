import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;
import com.polytech.web.FeedController;
import config.AppConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import persistence.MemoryStoryRepository;
import persistence.StoryRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PublicationTest {
    private FeedController feedController;

/*    @Before
    public void init_data(){
        StoryRepository stories = new MemoryStoryRepository();
        FeedService feedService = new FeedService(stories);
        PublicationService publicationService = new PublicationService(stories);
        feedController = new FeedController(feedService, publicationService);
    }*/

    @Before
    public void init(){
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        feedController = container.getBean(FeedController.class);
    }

    @Test
    public void should_post_story(){
        //GIVEN
        String story = "Hi Info4";

        //WHEN
        feedController.post(new Story(story));

        //THEN
        List<Story> postedStories = feedController.feed();
        assertEquals(Arrays.asList(new Story("Hi Info4")).get(0).getContent(), postedStories.get(0).getContent());
    }
}
