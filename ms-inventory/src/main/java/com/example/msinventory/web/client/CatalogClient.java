package com.example.msinventory.web.client;

import com.example.msinventory.entity.OfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Component
public class CatalogClient {

    private static final Logger LOGGER = Logger.getLogger(CatalogClient.class.getName());

    protected String serviceUrl = "http://localhost:8081";

    private final RestTemplate restTemplate;

    @Autowired
    public CatalogClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OfferDTO getOffer(Long id) {
        OfferDTO offerDTO = restTemplate.getForObject(serviceUrl + "/offers/{id}", OfferDTO.class, id);

        LOGGER.info(offerDTO.toString());
        return offerDTO;
    }

}
