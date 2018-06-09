package com.francescociulla.springboot.security;

import com.francescociulla.springboot.model.JwtAuthenticationToken;
import com.francescociulla.springboot.jwtuser.JwtUser;
import com.francescociulla.springboot.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/*
    Where authentication happens

    Extending Spring base token system with our jwt token
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final JwtValidator validator;

    @Autowired
    public JwtAuthenticationProvider(JwtValidator validator) {
        this.validator = validator;
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        //cast Spring token to our JWT Authentication Token
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        //AUTHENTICATION IN PROGRESS
        System.out.println("Authenticating Token: " + token + " for user: " + username);

        //VALIDATE token (JwtUser is the particular model to validate)
        JwtUser jwtUser = validator.validate(token);

        //now lets check if this particular user is gonna exists or not
        if (jwtUser == null) {
            throw new RuntimeException("JWT Token is incorrect!");
        }

        //Token Validator successful
        System.out.println("Token validated for " + jwtUser);

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JwtUserDetails(jwtUser.getUserName(), token, jwtUser.getPassword(), grantedAuthorities);
    }

    //Token class used by other classes as a model
    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }

    //No need for now
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
    }
}
