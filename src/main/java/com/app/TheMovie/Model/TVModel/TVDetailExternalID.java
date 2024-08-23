package com.app.TheMovie.Model.TVModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TVDetailExternalID {
    private String id, facebook_id, instagram_id, twitter_id;

    public String getFacebook_id() {
        facebook_id = "https://www.facebook.com/" + facebook_id;
        return facebook_id;
    }

    public String getInstagram_id() {
        instagram_id = "https://www.instagram.com/" + instagram_id;
        return instagram_id;
    }

    public String getTwitter_id() {
        twitter_id = "https://twitter.com/" + twitter_id;
        return twitter_id;
    }

}
