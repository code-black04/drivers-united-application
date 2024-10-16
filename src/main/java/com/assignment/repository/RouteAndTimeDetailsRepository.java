package com.assignment.repository;

import com.assignment.entity.RouteAndTimeDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteAndTimeDetailsRepository extends JpaRepository<RouteAndTimeDetailsEntity, Long> {
}
