package uk.gov.hmcts.lifeevents.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${default.name:default}", url="${default.url:https://api.lev.homeoffice.gov.uk}", configuration = ClientConfiguration.class)
public interface DefaultApiClient extends DefaultApi {
}
