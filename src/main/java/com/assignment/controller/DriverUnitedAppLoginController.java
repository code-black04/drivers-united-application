package com.assignment.controller;

import com.assignment.dtos.DriverDto;
import com.assignment.service.DriverUnitedAppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/auth")
public class DriverUnitedAppLoginController {

    @Autowired
    DriverUnitedAppLoginService service;

    @PostMapping
    public ResponseEntity<DriverDto> register(@RequestBody DriverDto dto) {
        DriverDto driverDto = service.registerDriver(dto);
        if (driverDto == null) {
            return new ResponseEntity<DriverDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(driverDto, HttpStatus.CREATED);
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<DriverDto> findDriverByUserName(@PathVariable String userName) {
        DriverDto driverDto = service.findByUserName(userName);
        if (driverDto == null) {
            return new ResponseEntity<DriverDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(driverDto, HttpStatus.OK);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DriverDto> findDriverById(@PathVariable String id) {
        DriverDto driverDto = service.findById(id);
        if (driverDto == null) {
            return new ResponseEntity<DriverDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(driverDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DriverDto>> findAllDrivers() {
        List<DriverDto> driverDtoList = service.findAllDrivers();
        if (driverDtoList == null) {
            return new ResponseEntity<List<DriverDto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(driverDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DriverDto> removeDriver(@PathVariable String id) {
        if (service.removeDriverWithId(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @PutMapping
    public ResponseEntity<DriverDto> updateDriverPassword(@RequestBody DriverDto dto) {
        DriverDto driverDto = service.findByUserName(dto.getUserName());
        if (driverDto == null) {
            return new ResponseEntity<DriverDto>(HttpStatus.NO_CONTENT);
        } else {
            driverDto.setPassword(dto.getPassword());
            driverDto = service.changePassword(driverDto);
            return new ResponseEntity<DriverDto>(driverDto, HttpStatus.OK);
        }
    }

}
