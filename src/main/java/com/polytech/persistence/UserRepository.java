package com.polytech.persistence;

import com.polytech.services.User;

public interface UserRepository {
    public void save(User user);
}
