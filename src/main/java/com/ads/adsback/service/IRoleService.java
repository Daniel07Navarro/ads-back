package com.ads.adsback.service;

import com.ads.adsback.model.entites.Role;

public interface IRoleService extends ICRUD<Role,Integer>{

    Role findOneByRole(String role) throws Exception;

}
