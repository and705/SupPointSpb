package com.nd705.suppointspb.service;

import com.nd705.suppointspb.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService { //security
    boolean save(UserDTO userDTO);
}
