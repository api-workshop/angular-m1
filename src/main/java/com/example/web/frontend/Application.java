package com.example.web.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@RefreshScope
@SpringBootApplication
public class Application {
    
    @Value("${security.oauth2.client.access-token-uri}")
    private String accessTokenUri;
    
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public OAuth2RestTemplate getRestTemplate() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setAccessTokenUri(accessTokenUri);
        resourceDetails.setClientId(clientId);
        resourceDetails.setClientSecret(clientSecret);
        
        return new OAuth2RestTemplate(resourceDetails);
    }
}