package com.example.demo.Service;

import java.util.HashMap;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClientBuilder;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest;
import com.example.demo.Entity.AuthBean;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final String IDENTITY_POOL_ID = "us-east-1:46bcd24c-a9ff-42b7-bac8-cecd746e6673";
    private final String IDENTITY_PROVIDE_NAME = "login.com.guanlinz.app";
    private final Long TOKEN_DURATION = 24 * 60 * 60l;

    public AuthBean auth(String userId) {
        var identityClient = AmazonCognitoIdentityClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider("default")).build();

        // create a new request to retrieve the token for your end user
        var request = new GetOpenIdTokenForDeveloperIdentityRequest();
        request.setIdentityPoolId(IDENTITY_POOL_ID);

        // set up your logins map with the username of your end user
        var logins = new HashMap<String, String>();
        logins.put(IDENTITY_PROVIDE_NAME, userId);
        request.setLogins(logins);

        // optionally set token duration (in seconds)
        request.setTokenDuration(TOKEN_DURATION);
        var response = identityClient.getOpenIdTokenForDeveloperIdentity(request);

        // obtain identity id and token to return to your client
        String identityId = response.getIdentityId();
        String token = response.getToken();
        var metadata = response.getSdkResponseMetadata();
        System.out.println(metadata);

        System.out.println("identityId: " + identityId);
        System.out.println("token: " + token);

        return new AuthBean(identityId, token, IDENTITY_POOL_ID, TOKEN_DURATION, IDENTITY_PROVIDE_NAME);
    }

}