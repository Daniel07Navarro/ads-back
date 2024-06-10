package com.ads.adsback.service.impl;

import com.ads.adsback.model.entites.Role;
import com.ads.adsback.repository.IGenericRepository;
import com.ads.adsback.repository.IRoleRepository;
import com.ads.adsback.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends CRUDImpl<Role,Integer> implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    IGenericRepository<Role, Integer> getRepo() {
        return roleRepository;
    }

    @Override
    public Role findOneByRole(String role) throws Exception {
        return roleRepository.findOneByRole(role);
    }
}
