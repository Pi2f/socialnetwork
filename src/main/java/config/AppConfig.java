package config;

import services.FeedService;
import services.PublicationService;
import web.FeedController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import persistence.JDBCStoryRepository;
import persistence.StoryRepository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    public StoryRepository storyRepository(DataSource dataSource) throws SQLException {
        return new JDBCStoryRepository(dataSource.getConnection());
    }

    @Bean
    public FeedService feedService(StoryRepository storyRepository){
        return new FeedService(storyRepository);
    }

    @Bean
    public PublicationService publicationService(StoryRepository storyRepository){
        return new PublicationService(storyRepository);
    }

    @Bean
    public FeedController feedController(FeedService feedService, PublicationService publicationService){
        return new FeedController(feedService,publicationService);
    }

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .addScripts("schema.sql")
                .build();
    }
}
