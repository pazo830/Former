package com.mycompany.mywebapp.com.mycompany.mywebapp.user.Services;

import com.mycompany.mywebapp.com.mycompany.mywebapp.user.dto.UserDto;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.model.Userss;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    Userss findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
