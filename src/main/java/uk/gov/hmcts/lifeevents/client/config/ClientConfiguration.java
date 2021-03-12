package uk.gov.hmcts.lifeevents.client.config;

import org.openapitools.configuration.ApiKeyRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@Configuration
@EnableConfigurationProperties
public class ClientConfiguration {

  @Autowired
  ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails;

  @Bean
  public OAuth2FeignRequestInterceptor bearerTokenRequestInterceptor() {
    return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resourceOwnerPasswordResourceDetails);
  }

  @Bean
  public ResourceOwnerPasswordResourceDetails bearerTokenResourceDetails(
          @Value("${bearertoken.accessTokenUri}") String accessTokenUri,
          @Value("${bearertoken.clientId}") String clientId,
          @Value("${bearertoken.clientSecret}") String clientSecret,
          @Value("${bearertoken.username}") String userName,
          @Value("${bearertoken.password}") String password
          ) {
    ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
    details.setAccessTokenUri(accessTokenUri);
    details.setClientId(clientId);
    details.setClientSecret(clientSecret);
    details.setUsername(userName);
    details.setPassword(password);
    return details;
  }
}
