package uk.gov.hmcts.lifeevents.client.config;

import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.service.DeathService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@EnableFeignClients(clients = DeathApiClient.class)
public class ServiceConfiguration {

  @Qualifier("levClient")
  private DeathApiClient deathApiClient;

  public ServiceConfiguration(final DeathApiClient deathApiClient) {
    this.deathApiClient = deathApiClient;
  }

  @Bean
  public DeathService deathService() {
    return new DeathService(deathApiClient);
  }
}
