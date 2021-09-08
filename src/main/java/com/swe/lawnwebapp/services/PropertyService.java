package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getProperties(){
        return propertyRepository.findAll();
    }

    public Optional<Property> findById(int id){
        return propertyRepository.findById(id);
    }
}
