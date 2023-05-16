package com.mycompany.mywebapp.com.mycompany.mywebapp.user.Services.Impl;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.Repository.RoleRepository;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.Repository.UserRepository;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.Services.UserService;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.dto.UserDto;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.model.Role;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.model.Userss;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public void saveUser(UserDto userDto) {
        Userss user = new Userss();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public Userss findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<Userss> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(Userss user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
