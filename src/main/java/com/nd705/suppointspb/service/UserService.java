package com.nd705.suppointspb.service;

import com.nd705.suppointspb.dto.UserDTO;
import com.nd705.suppointspb.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService { //security
    boolean save(UserDTO userDTO);
    void save(User user);
    List<UserDTO> getAll();
    User findByName(String name);
    void updateProfile(UserDTO userDTO);

}
