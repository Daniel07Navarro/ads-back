package com.ads.adsback.controller;


import com.ads.adsback.model.entites.User;
import com.ads.adsback.service.IRoleService;
import com.ads.adsback.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UsuarioController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    private final PasswordEncoder passwordEncoder;

    public UsuarioController(PasswordEncoder passwordEncoder){
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() throws Exception{
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
        /*
        Predicate<User> validateUsername = u -> userService.findOneByUsername(u.getUsername()) != null;
        Predicate<User> validateEmail = u -> userService.findOneByEmail(u.getEmail()) != null;
        String roleName = user.getRole().getRole();
        Role role = roleService.findOneByRole(roleName);
        if(validateUsername.test(user))
            return new ResponseEntity<>(Map.of("mensaje","El username se encuentra en uso"), HttpStatus.CONFLICT);

        if(validateEmail.test(user))
            return new ResponseEntity<>(Map.of("mensaje","El email se encuentra en uso"), HttpStatus.CONFLICT);

        if(role == null){
            roleService.save(user.getRole());
        }else{
            user.setRole(role);
        }*/

    }

}
