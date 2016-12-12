package com.home.content.test.helpers;


public enum Versions {
    TITLESERVICEVERSION1("application/vnd.uk.sky.gonzales.title.v1+json"),
    TITLESERVICEVERSION2("application/vnd.uk.sky.gonzales.title.v2+json"),
    TITLESERVICEVERSION3("application/vnd.uk.sky.gonzales.title.v3+json");

    private String versionHeader;

    Versions(String versionHeader){
        this.versionHeader=versionHeader;
    }

    public String getVersionHeader(){
        return versionHeader;
    }
}
