package com.example.midtermexam;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonParser extends AsyncTask<String,String,String> {

    public List<GithubDetails> githubDetails = new ArrayList<GithubDetails>();
    BufferedInputStream inputStream;
    JSONArray jsonArray;
    String result = "";
    public ProgressDialog progressDialog;
    Activity activity;
    Context context;

    public JsonParser(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        this.progressDialog = new ProgressDialog(this.context);
    }

    @Override
    protected void onPreExecute() {
        Log.i("TAG","onPreExecute called");
        super.onPreExecute();
        progressDialog.dismiss();
        progressDialog.setMessage("Loading");
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setOnShowListener((dialogInterface) -> {
            JsonParser.this.cancel(true);
        });
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.i("TAG","doInBackground called");
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(Url.fetchData);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            result = readStream();
            Log.i("TAG","got the data");
        } catch(IOException e) {
            e.printStackTrace();
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
            Log.i("TAG",result);
            jsonArray = new JSONArray(result);

            if(jsonArray != null) {
                for(int index = 0;index<jsonArray.length();index++) {

                    GithubDetails pd = new GithubDetails(
                            jsonArray.getJSONObject(index).getJSONObject("owner").getString("login"),
                            jsonArray.getJSONObject(index).getString("name")
                    );
                    githubDetails.add(pd);
                }

            } else {
                Log.i("Json data is null",jsonArray.toString());
            }
            ListView listView;
            listView = (ListView)this.activity.findViewById(R.id.listView);
            GithubAdapter githubAdapter = new GithubAdapter(this.context,githubDetails);
            listView.setAdapter(githubAdapter);
            progressDialog.cancel();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
