package com.assignment.repository;

import com.assignment.entity.TravelTimeDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelTimeDetailsRepository extends JpaRepository<TravelTimeDetailsEntity, Long> {
}
