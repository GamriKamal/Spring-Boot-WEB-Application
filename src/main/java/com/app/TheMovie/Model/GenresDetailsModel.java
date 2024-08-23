package com.app.TheMovie.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenresDetailsModel {
    private String id, name;

    public List<GenresDetailsModel> fromJSONtoList(JSONArray arr) throws JSONException {
        List<GenresDetailsModel> list = new ArrayList<>();
        for(int i = 0; i < arr.length(); i++){
            list.add(new GenresDetailsModel(
                    arr.getJSONObject(i).getString("id"),
                    arr.getJSONObject(i).getString("name")

            ));
        }
        return list;
    }
}
