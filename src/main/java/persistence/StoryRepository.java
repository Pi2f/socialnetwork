package persistence;

import services.Story;
import java.util.List;

public interface StoryRepository {
    List<Story> findAll();
    void save(Story content);
}
