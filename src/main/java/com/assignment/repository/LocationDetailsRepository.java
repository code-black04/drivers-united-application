package com.assignment.repository;

import com.assignment.entity.LocationDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDetailsRepository extends CrudRepository<LocationDetailsEntity, Long> {
}
