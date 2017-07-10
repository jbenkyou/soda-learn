package com.soda.app.mapper;

import com.soda.app.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> listUser();
}
