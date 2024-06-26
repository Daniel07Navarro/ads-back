package com.ads.adsback.repository;

import com.ads.adsback.token.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITokenRepository extends IGenericRepository<Token,Integer>{

    @Query("""
    select t from Token t inner join User u on t.user.idUser = u.idUser
    where u.idUser =:userId and (t.expired = false or t.revoked=false)
    """)
     List<Token> findAllValidTokensByUser(Integer userId);

    Optional<Token> findByToken(String token);

}
