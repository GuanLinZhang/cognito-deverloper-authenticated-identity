package com.example.demo.Entity;

public class AuthBean {
    private String identityId;
    private String token;

    public AuthBean(String identityId, String token) {
        this.identityId = identityId;
        this.token = token;
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
