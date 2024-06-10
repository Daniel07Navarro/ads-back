package com.ads.adsback.repository;

import com.ads.adsback.model.entites.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IGenericRepository<User,Integer>{


    /*
    @Query(value = "select * from user_data where email= :email ",nativeQuery = true)
    User findOneByEmail(@Param("email") String email);
    */

    //@Query("FROM User c WHERE c.email = ?1")
    //User findOneByEmail(String email);

    User findOneByEmail(String email);


    @Query(value = "select * from user_data where username= :username",nativeQuery = true)
    User findOneByUsername(@Param("username") String username);


}
