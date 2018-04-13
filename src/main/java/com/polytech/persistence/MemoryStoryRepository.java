package com.polytech.persistence;

import com.polytech.services.Story;

import java.util.ArrayList;
import java.util.List;

public class MemoryStoryRepository implements StoryRepository {
    static List<Story> stories = new ArrayList<>();

    public void save(Story content) {
        stories.add(content);
    }

    public List<Story> findAll() {
        return stories;
    }
}
