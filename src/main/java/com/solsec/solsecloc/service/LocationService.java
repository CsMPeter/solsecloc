package com.solsec.solsecloc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solsec.solsecloc.domain.Location;
import com.solsec.solsecloc.exception.ResourceNotFoundException;
import com.solsec.solsecloc.persistence.LocationRepository;
import com.solsec.solsecloc.transfer.request.SaveLocationRequest;
import com.solsec.solsecloc.transfer.response.LocationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class);

    private final LocationRepository locationRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public LocationService(LocationRepository locationRepository, ObjectMapper objectMapper) {
        this.locationRepository = locationRepository;
        this.objectMapper = objectMapper;
    }

    public Location createLocation(SaveLocationRequest request){
        LOGGER.info("Adding a new location {}", request);
        Location location = objectMapper.convertValue(request,Location.class);

        return locationRepository.save(location);
    }

    public Location getLocation(long id) {
        LOGGER.info("Retrieving location {}",id);
        return locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location" + id + "does not exist."));
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public void deleteLocation(long id){
        LOGGER.info("Removing location {},id");
        locationRepository.deleteById(id);
    }
}
