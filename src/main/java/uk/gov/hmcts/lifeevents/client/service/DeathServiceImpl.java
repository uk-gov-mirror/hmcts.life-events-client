package uk.gov.hmcts.lifeevents.client.service;

import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeathServiceImpl implements DeathService {

    private final DeathApiClient deathApiClient;

    public DeathServiceImpl(DeathApiClient deathApiClient) {
        this.deathApiClient = deathApiClient;
    }

    @Override
    public List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date){
        return deathApiClient.searchV1Death(forenames, surname, date).getBody();
    }

    @Override
    public V1Death getDeathRecordById(Integer id){
        return deathApiClient.readV1Death(id).getBody();
    }
}
