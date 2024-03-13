package com.assignment.service;

import com.assignment.dtos.DriverDto;
import com.assignment.entity.DriverEntity;
import com.assignment.mapper.DriverDtoEntityMapper;
import com.assignment.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DriverUnitedAppLoginService {
    @Autowired
    private DriverRepository dao;

    @Autowired
    private DriverDtoEntityMapper mapper;


    public DriverDto registerDriver(DriverDto dto){
       dto.setPassword(Base64.getEncoder().encodeToString(dto.getPassword().getBytes(StandardCharsets.UTF_8)));
       DriverEntity entity= mapper.convertToDriverEntity(dto);
       entity= dao.save(entity);
       return mapper.convertToDriverDto(entity);
    }

    public DriverEntity login(String userName,String password){
        DriverEntity entity;
        try {
           entity = dao.findByUserNameAndPassword(userName,password).get();
        }catch (NoSuchElementException exception){
            return null;
        }
        return entity;
    }
    public DriverDto findByUserName(String userName){
        DriverEntity entity=dao.findByUserName(userName).get();
        return mapper.convertToDriverDto(entity);
    }
    public DriverDto findById(String id){
        DriverEntity entity=dao.findById(id).get();
        return mapper.convertToDriverDto(entity);
    }
    public List<DriverDto> findAllDrivers(){
        List<DriverEntity> entityList=dao.findAll();
        return mapper.convertToDriverDtoList(entityList);
    }
    public boolean removeDriverWithId(String id){
        try {
            dao.deleteById(id);
            if(dao.existsById(id))
                return false;
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public DriverDto changePassword(DriverDto driverDto){
        DriverEntity entity=dao.save(mapper.convertToDriverEntity(driverDto));
        return mapper.convertToDriverDto(entity);
    }
}
