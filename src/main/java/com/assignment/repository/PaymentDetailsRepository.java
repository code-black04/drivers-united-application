package com.assignment.repository;

import com.assignment.entity.PaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetailsEntity, Long> {
}
