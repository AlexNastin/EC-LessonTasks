package com.example.mscatalog.repository;

import com.example.mscatalog.entity.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long>{
}
