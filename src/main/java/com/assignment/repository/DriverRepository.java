package com.assignment.repository;

import com.assignment.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, String> {

    Optional<DriverEntity> findByUserName(String s);
    Optional<DriverEntity> findByUserNameAndPassword(String userName,String password);


}
