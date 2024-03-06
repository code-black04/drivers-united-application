package com.assignment.repository;

import com.assignment.entity.RouteAndTimeDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteAndTimeDetailsRepository extends CrudRepository<RouteAndTimeDetailsEntity, Long> {
}
