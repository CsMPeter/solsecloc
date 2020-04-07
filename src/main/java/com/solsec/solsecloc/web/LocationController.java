package com.solsec.solsecloc.web;

import com.solsec.solsecloc.domain.Location;
import com.solsec.solsecloc.service.LocationService;
import com.solsec.solsecloc.transfer.request.SaveLocationRequest;
import com.solsec.solsecloc.transfer.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

   @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody @Valid SaveLocationRequest request) {
       Location location = locationService.createLocation(request);
        return new ResponseEntity<>(location, HttpStatus.CREATED);

    }

    @GetMapping
    @RequestMapping(value="/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        Location location = locationService.getLocation(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteLocation(@PathVariable Long id){
       locationService.deleteLocation(id);
       return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations(){
        return ResponseEntity.ok(locationService.getAllLocations());
   }
}
