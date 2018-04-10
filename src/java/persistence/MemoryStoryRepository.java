package persistence;

import com.polytech.services.Story;

import java.util.LinkedList;
import java.util.List;

public class MemoryStoryRepository implements StoryRepository {
    static List<Story> stories = new LinkedList<Story>();

    public List<Story> getStories() {
        return stories;
    }
}
