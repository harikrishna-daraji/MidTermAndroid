package com.example.midtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OwnerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_info);

        TextView nameTV = findViewById(R.id.name);
        TextView emailTV = findViewById(R.id.email);
        TextView twitterUsernameTV = findViewById(R.id.twitter_username);
        TextView publicRepoTV = findViewById(R.id.public_repos);
        TextView publicGiftsTV = findViewById(R.id.public_gits);
        TextView followerTV = findViewById(R.id.followers);
        TextView followigTV = findViewById(R.id.following);
        TextView blogTV = findViewById(R.id.blog);

        Owner owner = (Owner)getIntent().getSerializableExtra("ownerInfo");

        nameTV.setText("Name : "+owner.getName());
        emailTV.setText("Email : "+owner.getEmail());
        twitterUsernameTV.setText("Twitter Username : "+owner.getTwitter_Username());
        publicRepoTV.setText("Public Repo : "+owner.getPublic_Repos());
        publicGiftsTV.setText("Public Gits : "+owner.getPublic_Gifts());
        followerTV.setText("Followers : "+owner.getFollowers());
        followigTV.setText("Following : "+owner.getFollowing());
        blogTV.setText("Blog : "+owner.getBlog());

    }
}