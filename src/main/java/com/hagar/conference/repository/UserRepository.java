package com.hagar.conference.repository;

import com.hagar.conference.model.User;

public interface UserRepository {
    User save(User user);
}
