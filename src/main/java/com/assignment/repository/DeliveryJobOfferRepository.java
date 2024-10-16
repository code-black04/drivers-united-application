package com.assignment.repository;

import com.assignment.entity.DeliveryJobOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryJobOfferRepository extends JpaRepository<DeliveryJobOfferEntity, Long> {

}

