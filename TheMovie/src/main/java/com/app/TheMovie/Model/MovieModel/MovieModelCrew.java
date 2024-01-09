package com.app.TheMovie.Model.MovieModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieModelCrew {
    private String id, job, credit_id, profile_path, name, known_for_department;
    public String getProfile_path() {
        profile_path = "http://image.tmdb.org/t/p/w500" + profile_path;
        System.out.println(profile_path);
        return profile_path;
    }
}
