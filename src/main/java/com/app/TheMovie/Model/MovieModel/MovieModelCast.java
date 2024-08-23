package com.app.TheMovie.Model.MovieModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieModelCast {
    private String id, cast_id, character, credit_id, name, known_for_department, profile_path;


    public MovieModelCast(String id, String cast_id, String character, String credit_id, String name, String known_for_department, String profile_path) {
        this.id = id;
        this.cast_id = cast_id;
        this.character = character;
        this.credit_id = credit_id;
        this.name = name;
        this.known_for_department = known_for_department;
        this.profile_path = profile_path;
    }

    public MovieModelCast(String id, String character, String credit_id, String name, String known_for_department, String profile_path) {
        this.id = id;
        this.character = character;
        this.credit_id = credit_id;
        this.name = name;
        this.known_for_department = known_for_department;
        this.profile_path = profile_path;
    }

    public String getProfile_path() {
        profile_path = "http://image.tmdb.org/t/p/w500" + profile_path;
        return profile_path;
    }
}
