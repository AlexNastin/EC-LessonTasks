package com.example.mscatalog.service;

import com.example.mscatalog.entity.Offer;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {

    Offer createOffer(Offer offer);

    Offer getOfferById(Long id);
}
