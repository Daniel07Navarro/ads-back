package com.ads.adsback.security;

import com.ads.adsback.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ads.adsback.model.entites.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository usuarioRepository;

    Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User usuario = usuarioRepository.findOneByEmail(email);
        if(usuario==null){
            throw new UsernameNotFoundException("USER NOT FOUNT");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        logger.info(usuario.getRole().getRole());
        String role = usuario.getRole().getRole();
        roles.add(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(),usuario.getPassword(),roles);
    }
}
