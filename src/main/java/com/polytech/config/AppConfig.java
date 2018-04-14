package com.polytech.config;

import com.polytech.persistence.JDBCUserRepository;
import com.polytech.persistence.UserRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.UserService;
import com.polytech.web.FeedController;
import com.polytech.web.RegisterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import com.polytech.persistence.JDBCStoryRepository;
import com.polytech.persistence.StoryRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
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
                //.addScripts("schema.sql")
                .build();
    }

    @Bean
    public UserRepository userRepository(DataSource dataSource){
        return new JDBCUserRepository(dataSource);
    }

    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return new UserService(userRepository, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RegisterController registerController(UserService userService){
        return new RegisterController(userService);
    }
}
