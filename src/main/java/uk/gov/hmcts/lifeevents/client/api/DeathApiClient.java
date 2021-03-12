package uk.gov.hmcts.lifeevents.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${death.name:death}", url="${death.url:https://api.lev.homeoffice.gov.uk}", configuration = ClientConfiguration.class)
public interface DeathApiClient extends DeathApi {
}
