package com.example.mscatalog.web.controller;

import com.example.mscatalog.entity.Offer;
import com.example.mscatalog.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        return new ResponseEntity<>(offerService.createOffer(offer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable Long id) {
        return new ResponseEntity<>(offerService.getOfferById(id), HttpStatus.OK);
    }
}
