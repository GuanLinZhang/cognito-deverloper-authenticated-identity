package com.example.demo.Entity;

public class AuthBean {
    private String identityId;
    private String token;
    private String identityPoolId;
    private Long duration;
    private String identityProvideName;
    
    public AuthBean(String identityId, String token, String identityPoolId, Long duration, String identityProvideName) {
        this.identityId = identityId;
        this.token = token;
        this.setIdentityPoolId(identityPoolId);
        this.setDuration(duration);
        this.setIdentityProvideName(identityProvideName);
    }

    public String getIdentityProvideName() {
        return identityProvideName;
    }

    public void setIdentityProvideName(String identityProvideName) {
        this.identityProvideName = identityProvideName;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getIdentityPoolId() {
        return identityPoolId;
    }

    public void setIdentityPoolId(String identityPoolId) {
        this.identityPoolId = identityPoolId;
    }

    public String getIdentityId() {
        return identityId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

}
