package com.app.TheMovie.Services;

import com.app.TheMovie.Interfaces.UserAccountRepository;
import com.app.TheMovie.Model.Account.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GetUserDetails {

    @Autowired
    private UserAccountRepository repo;

    public UserAccount getUserDetails(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return repo.findByUsername(userDetails.getUsername());
    }
}
