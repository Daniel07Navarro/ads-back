package com.ads.adsback.service.impl;

import com.ads.adsback.exception.ValidationException;
import com.ads.adsback.model.entites.Role;
import com.ads.adsback.model.entites.User;
import com.ads.adsback.repository.IGenericRepository;
import com.ads.adsback.repository.IRoleRepository;
import com.ads.adsback.repository.IUserRepository;
import com.ads.adsback.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class UserServiceImpl extends CRUDImpl<User,Integer> implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public User save(User user) throws Exception {
        Predicate<User> validateEmail = u -> userRepository.findOneByEmail(u.getEmail()) != null;
        String roleName= user.getRole().getRole();
        Role role = roleRepository.findOneByRole(roleName);

        if(validateEmail.test(user))
            throw new ValidationException("Error, email ya registrado");

        if(role == null){
            roleRepository.save(user.getRole());
        }else{
            user.setRole(role);
        }
        return super.save(user);
    }

    @Override
    IGenericRepository<User, Integer> getRepo() {
        return userRepository;
    }

    @Override
    public User findOneByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public User findOneByEmail(String email)  {
        return userRepository.findOneByEmail(email);
    }
}
