package com.example.midtermexam;

public class GithubDetails {

    private String ownerName;
    private  String repositoryName;

    public GithubDetails(String ownerName, String repositoryName) {
        this.ownerName = ownerName;
        this.repositoryName = repositoryName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

}
