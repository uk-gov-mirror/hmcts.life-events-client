package uk.gov.hmcts.lifeevents.client.service;

import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeathService {

    private final DeathApiClient deathApiClient;

    public DeathService(DeathApiClient deathApiClient) {
        this.deathApiClient = deathApiClient;
    }

    public List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date){
        return deathApiClient.searchV1Death(forenames, surname, date).getBody();
    }

    public V1Death getDeathRecordById(Integer id){
        return deathApiClient.readV1Death(id).getBody();
    }
}
