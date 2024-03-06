package com.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelTimeDetailsRepository extends CrudRepository<TravelTimeDetailsRepository, Long> {
}
