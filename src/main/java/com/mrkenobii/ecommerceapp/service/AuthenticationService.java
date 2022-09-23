package com.mrkenobii.ecommerceapp.service;

import com.mrkenobii.ecommerceapp.model.AuthenticationToken;
import com.mrkenobii.ecommerceapp.model.User;
import com.mrkenobii.ecommerceapp.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final TokenRepository tokenRepository;
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }
}
