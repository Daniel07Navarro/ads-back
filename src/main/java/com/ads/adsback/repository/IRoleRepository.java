package com.ads.adsback.repository;

import com.ads.adsback.model.entites.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends IGenericRepository<Role,Integer>{

   Role findOneByRole(String role);

}
