package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Role;
import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class MyUserDatailsService implements UserDetailsService {

    private UserRepository userRepository;

    public MyUserDatailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            User user = userRepository.findByUsername(username);
            if(user==null){
                throw new UsernameNotFoundException(username);
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), getAuthories(user));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuário não Encontrado!");
        }
    }

    private Set<GrantedAuthority> getAuthories(User user) {

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (Role role: user.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
