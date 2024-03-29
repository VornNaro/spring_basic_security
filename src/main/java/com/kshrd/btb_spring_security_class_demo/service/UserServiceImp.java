package com.kshrd.btb_spring_security_class_demo.service;

import com.kshrd.btb_spring_security_class_demo.entity.UserInfo;
import com.kshrd.btb_spring_security_class_demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findUserByUsername(username);
       if (userInfo == null){
           throw new UsernameNotFoundException("User not found");
       }
        return userInfo;
    }
}
