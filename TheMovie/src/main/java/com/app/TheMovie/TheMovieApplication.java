package com.app.TheMovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TheMovieApplication {
	public static void main(String[] args){
		SpringApplication.run(TheMovieApplication.class, args);
    }
}
