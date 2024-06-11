package com.ads.adsback.controller;


import com.ads.adsback.model.DTO.UserDTO;
import com.ads.adsback.model.entites.User;
import com.ads.adsback.service.IRoleService;
import com.ads.adsback.service.IUserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UsuarioController(PasswordEncoder passwordEncoder){
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() throws Exception{
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO userDTO) throws Exception {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userService.save(convertDTOToUser(userDTO));
        return new ResponseEntity<>(convertUserToDTO(user),HttpStatus.CREATED);
    }

    private UserDTO convertUserToDTO(User user){
        return userMapper.map(user, UserDTO.class);
    }

    private User convertDTOToUser(UserDTO userDTO){
        return userMapper.map(userDTO, User.class);
    }

}
