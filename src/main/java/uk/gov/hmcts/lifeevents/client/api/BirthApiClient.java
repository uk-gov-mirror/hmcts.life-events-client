package uk.gov.hmcts.lifeevents.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${birth.name:birth}", url="${birth.url:https://api.lev.homeoffice.gov.uk}", configuration = ClientConfiguration.class)
public interface BirthApiClient extends BirthApi {
}
