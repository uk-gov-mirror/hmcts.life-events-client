package uk.gov.hmcts.lifeevents.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${partnership.name:partnership}", url="${partnership.url:https://api.lev.homeoffice.gov.uk}", configuration = ClientConfiguration.class)
public interface PartnershipApiClient extends PartnershipApi {
}
