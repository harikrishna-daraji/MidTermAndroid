package com.example.midtermexam;

public class GithubDetails {

    private String ownerName;
    private  String repositoryName;
    private String urlStr;

    public GithubDetails(String ownerName, String repositoryName, String urlStr) {
        this.ownerName = ownerName;
        this.repositoryName = repositoryName;
        this.urlStr = urlStr;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getUrlStr() { return urlStr; }

}
