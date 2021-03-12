package uk.gov.hmcts.lifeevents.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${marriage.name:marriage}", url="${marriage.url:https://api.lev.homeoffice.gov.uk}", configuration = ClientConfiguration.class)
public interface MarriageApiClient extends MarriageApi {
}
