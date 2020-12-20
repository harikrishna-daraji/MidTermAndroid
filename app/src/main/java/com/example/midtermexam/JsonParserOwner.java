package com.example.midtermexam;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

public class JsonParserOwner extends AsyncTask<String,String,String> {

    BufferedInputStream inputStream;
    String urlStr;
    String result="";
    Activity activity;

    JsonParserOwner(String url,Activity activity) {
        this.urlStr = url;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlStr);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            result = readStream();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String readStream() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while((line=bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return stringBuilder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (jsonObject != null) {
                Owner owner = new Owner(
                        jsonObject.getString("login"),
                        jsonObject.getString("email"),
                        jsonObject.getString("twitter_username"),
                        jsonObject.getInt("public_repos"),
                        jsonObject.getInt("public_gists"),
                        jsonObject.getInt("followers"),
                        jsonObject.getInt("following"),
                        jsonObject.getString("blog")
                );
                Intent intent = new Intent(activity,OwnerInfo.class);
                intent.putExtra("ownerInfo",owner);
                activity.startActivity(intent);
            } else {
                Log.i("TAG","It is null");
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

}
