package persistence;

import com.polytech.services.Story;
import java.util.List;

public interface StoryRepository {
    List<Story> getStories();
}
