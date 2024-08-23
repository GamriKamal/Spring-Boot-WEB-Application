package com.app.TheMovie.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private UserDetailsService userDetailsService;

    @Autowired
    public void SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(10));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http
//                .httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(antMatcher("/h2-console/**")).permitAll()
//                )
//                .headers(headers -> headers.frameOptions(Customizer.withDefaults()).disable())

                .authorizeHttpRequests((request) -> request
                        .requestMatchers(antMatcher("/account")).authenticated()
                        .requestMatchers(antMatcher("/account/favouriteMovie")).authenticated()
                        .requestMatchers(antMatcher("/account/watchListMovie")).authenticated()
                        .requestMatchers(antMatcher("/account/favouriteTV")).authenticated()
                        .requestMatchers(antMatcher("/account/watchListTV")).authenticated()
                        .requestMatchers(antMatcher("/addFavouriteMovie")).authenticated()
                        .requestMatchers(antMatcher("/addWatchlistMovie")).authenticated()
                        .requestMatchers(antMatcher("/addFavouriteTV")).authenticated()
                        .requestMatchers(antMatcher("/addWatchlistTV")).authenticated()
                        .anyRequest().permitAll()
                )

                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                ).logout((logout) -> logout.permitAll());

        return http.build();
    }

}

