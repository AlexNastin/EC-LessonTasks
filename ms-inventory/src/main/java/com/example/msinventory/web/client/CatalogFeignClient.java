package com.example.msinventory.web.client;

import com.example.msinventory.entity.OfferDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("catalog-service")
public interface CatalogFeignClient {

    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    OfferDTO getOffer(@PathVariable("offerId") Long offerId);
}
