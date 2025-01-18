package com.example.rest.service;

import com.example.rest.model.Location;
import com.example.rest.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;
    
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    public Optional<Location> getLocationById(Integer id) {
        return locationRepository.findById(id);
    }
    
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
}
