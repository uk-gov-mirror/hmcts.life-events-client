package org.openapitools.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

@Configuration
@EnableConfigurationProperties
public class ClientConfiguration {

  @Bean
  @ConditionalOnProperty("lifeeventverificationlev.security.bearerToken.client-id")
  public OAuth2FeignRequestInterceptor bearerTokenRequestInterceptor() {
    return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), bearerTokenResourceDetails());
  }

  @Bean
  @ConditionalOnProperty("lifeeventverificationlev.security.bearerToken.client-id")
  @ConfigurationProperties("lifeeventverificationlev.security.bearerToken")
  public AuthorizationCodeResourceDetails bearerTokenResourceDetails() {
    AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
    details.setAccessTokenUri("https://sso.digital.homeoffice.gov.uk/auth/realms/lev/protocol/openid-connect/token");
    details.setUserAuthorizationUri("https://sso.digital.homeoffice.gov.uk/auth/realms/lev/protocol/openid-connect/auth");
    return details;
  }

  @Value("${lifeeventverificationlev.security.mockHeaderClient.key:}")
  private String mockHeaderClientKey;

  @Bean
  @ConditionalOnProperty(name = "lifeeventverificationlev.security.mockHeaderClient.key")
  public ApiKeyRequestInterceptor mockHeaderClientRequestInterceptor() {
    return new ApiKeyRequestInterceptor("header", "X-Auth-Aud", this.mockHeaderClientKey);
  }

  @Value("${lifeeventverificationlev.security.mockHeaderUsername.key:}")
  private String mockHeaderUsernameKey;

  @Bean
  @ConditionalOnProperty(name = "lifeeventverificationlev.security.mockHeaderUsername.key")
  public ApiKeyRequestInterceptor mockHeaderUsernameRequestInterceptor() {
    return new ApiKeyRequestInterceptor("header", "X-Auth-Username", this.mockHeaderUsernameKey);
  }

}
