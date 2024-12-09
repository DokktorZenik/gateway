package com.example.gateway.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Utils {

    @Value("${external.cdp-api}")
    private String CDP_DOMEN;

    @Value("${external.metadata-api}")
    private String METADATA_DOMEN;

    @Value("${external.metric-api}")
    private String METRIC_DOMEN;


    @Value("${external.user-service-api}")
    private String USER_DOMAIN;
}
