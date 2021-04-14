package uk.gov.hmcts.lifeevents.client.service;

import uk.gov.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NoOpDeathServiceImpl implements DeathService  {

    public static final String NOT_IMPLEMENTED = "Not implemented";

    public List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date){
        return null;
    }

    public V1Death getDeathRecordById(Integer id){
        return null;
    }
}
