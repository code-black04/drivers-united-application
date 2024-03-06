package com.assignment.repository;

import com.assignment.entity.PaymentDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends CrudRepository<PaymentDetailsEntity, Long> {
}
