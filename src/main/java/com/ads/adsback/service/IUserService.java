package com.ads.adsback.service;

import com.ads.adsback.model.entites.User;

public interface IUserService extends ICRUD<User,Integer>{

    User findOneByUsername(String username);

    User findOneByEmail(String email) ;
}
