package com.example.midtermexam;

import java.io.Serializable;

public class Owner implements Serializable {

    private String name;
    private String email;
    private String twitter_Username;
    private int public_Repos;
    private int public_Gifts;
    private int followers;
    private int following;
    private String blog;

    public Owner(String name, String email, String twitter_Username, int public_Repos, int public_Gifts, int followers, int following, String blog) {
        this.name = name;
        this.email = email;
        this.twitter_Username = twitter_Username;
        this.public_Repos = public_Repos;
        this.public_Gifts = public_Gifts;
        this.followers = followers;
        this.following = following;
        this.blog = blog;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTwitter_Username() {
        return twitter_Username;
    }

    public int getPublic_Repos() {
        return public_Repos;
    }

    public int getPublic_Gifts() {
        return public_Gifts;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public String getBlog() {
        return blog;
    }

}
