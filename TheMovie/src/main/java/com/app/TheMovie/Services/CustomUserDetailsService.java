package com.app.TheMovie.Services;

import com.app.TheMovie.Model.Account.UserAccount;
import com.app.TheMovie.Interfaces.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserAccountRepository repo;

    @Autowired
    public void setUserAccountRepository(UserAccountRepository userAccountRepository) {
        this.repo = userAccountRepository;
    }


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(repo.findAll());
        UserAccount account = repo.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }


        return User.withUsername(account.getUsername())
                .password(passwordEncoder().encode(account.getPassword()))
                .roles(account.getRole())
                .build();
    }
}


