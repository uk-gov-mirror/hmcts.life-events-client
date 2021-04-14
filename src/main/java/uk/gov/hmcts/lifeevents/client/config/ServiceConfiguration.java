package uk.gov.hmcts.lifeevents.client.config;

import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.service.DeathService;
import uk.gov.hmcts.lifeevents.client.service.DeathServiceImpl;
import uk.gov.hmcts.lifeevents.client.service.NoOpDeathServiceImpl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@EnableFeignClients(clients = DeathApiClient.class)
public class ServiceConfiguration {

  private DeathApiClient deathApiClient;

  public ServiceConfiguration(final DeathApiClient deathApiClient) {
    this.deathApiClient = deathApiClient;
  }

  @Bean
  @ConditionalOnProperty(name = "bearertoken.publicCertificate")
  public DeathService deathService() {
    return new DeathServiceImpl(deathApiClient);
  }

  @Bean
  @ConditionalOnMissingBean(value = DeathServiceImpl.class)
  public DeathService noOpDeathService() {
    return new NoOpDeathServiceImpl();
  }
}
