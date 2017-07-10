package com.soda.app.service;

import com.soda.app.model.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    List<User> evictUser();
}
