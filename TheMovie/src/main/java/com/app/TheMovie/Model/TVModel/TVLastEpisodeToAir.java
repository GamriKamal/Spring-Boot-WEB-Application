package com.app.TheMovie.Model.TVModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TVLastEpisodeToAir {
    private String id, name, overview, air_date, episode_number, episode_type, still_path;

    public List<TVLastEpisodeToAir> fromJSONtoListTV(JSONObject obj) throws JSONException {
        List<TVLastEpisodeToAir> list = new ArrayList<>();
        for(int i = 0; i < obj.length(); i++){
            list.add(new TVLastEpisodeToAir(
                    obj.getString("id"),
                    obj.getString("name"),
                    obj.getString("overview"),
                    obj.getString("air_date"),
                    obj.getString("episode_number"),
                    obj.getString("episode_type"),
                    obj.getString("still_path")
            ));
        }
        return list;
    }

}
