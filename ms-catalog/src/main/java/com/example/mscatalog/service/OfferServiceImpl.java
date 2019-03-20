package com.example.mscatalog.service;

import com.example.mscatalog.entity.Offer;
import com.example.mscatalog.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OfferServiceImpl implements OfferService {

    private static final Logger LOGGER = Logger.getLogger(OfferServiceImpl.class.getName());

    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer getOfferById(Long id) {
        Offer offer = offerRepository.findOne(id);
        LOGGER.info("Found offer: " + offer);
        return offerRepository.findOne(id);
    }
}
