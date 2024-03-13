package com.assignment.repository;

import com.assignment.entity.DeliveryJobOfferEntity;
import com.assignment.entity.JobOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJobOfferRepository extends JpaRepository <DeliveryJobOfferEntity, String>{

}

