package com.manohar.taskproject.security;

import com.manohar.taskproject.entity.Users;
import com.manohar.taskproject.exception.UserNotFound;
import com.manohar.taskproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(email).orElseThrow(
                ()-> new UserNotFound(String.format("User with email : %s is not found",email)));

        Set<String> roles = new HashSet<String>();
        roles.add("ROLE_ADMIN");
        return new User(users.getEmail(), users.getPassword(), userAuthorities(roles));
    }

    private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles){

        return roles.stream().map(
                role ->new SimpleGrantedAuthority(role)
        ).collect(Collectors.toList());
    }
}
