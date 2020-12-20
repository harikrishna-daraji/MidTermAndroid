package com.example.midtermexam;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GithubAdapter extends ArrayAdapter<GithubDetails> {

    List<GithubDetails> githubDetails;
    private Context context;

    public GithubAdapter(Context context, List<GithubDetails> githubDetails) {
        super(context,R.layout.list_item,githubDetails);
        this.context = context;
        this.githubDetails = githubDetails;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item,null);
        }

        GithubDetails githubDetail = githubDetails.get(position);

        TextView ownerName = convertView.findViewById(R.id.ownerName);
        ownerName.setText("Owner name: "+githubDetail.getOwnerName());
        TextView repositoryName = convertView.findViewById(R.id.repositoryName);
        repositoryName.setText("Repository Name: "+githubDetail.getRepositoryName());

        return convertView;
    }


}
