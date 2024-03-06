package com.assignment.repository;

import com.assignment.entity.DriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, String> {

}
