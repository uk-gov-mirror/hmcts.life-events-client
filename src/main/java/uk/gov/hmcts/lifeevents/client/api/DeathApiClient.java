package uk.gov.hmcts.lifeevents.client.api;

import uk.gov.hmcts.lifeevents.client.config.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${death.name:death}", url="${death.url:https://api.lev.homeoffice.gov.uk}", configuration = ClientConfiguration.class)
public interface DeathApiClient extends DeathApi {
}
