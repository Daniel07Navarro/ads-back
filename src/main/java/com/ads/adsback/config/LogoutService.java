package com.ads.adsback.config;

import com.ads.adsback.repository.ITokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class LogoutService implements LogoutHandler {

    @Autowired
    private ITokenRepository tokenRepository;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String tokenHeader = request.getHeader("Authorization");
        String nombre = null;
        String jwtToken = null;

        if(tokenHeader!=null){
            if(tokenHeader.startsWith("Bearer ")|| tokenHeader.startsWith("bearer ")){
                jwtToken = tokenHeader.substring(7);
                var storedToken = tokenRepository.findByToken(jwtToken)
                        .orElse(null);
                if(storedToken!=null){
                    storedToken.setExpired(true);
                    storedToken.setRevoked(true);
                    tokenRepository.save(storedToken);
                }
            }else{
                return;
            }
        }
    }
}
