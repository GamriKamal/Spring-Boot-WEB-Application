package com.app.TheMovie.Model.MovieModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieVideoModel {
    private String name, key;

    public String getKey() {
        return "https://www.youtube.com/embed/" + key;
    }
}
