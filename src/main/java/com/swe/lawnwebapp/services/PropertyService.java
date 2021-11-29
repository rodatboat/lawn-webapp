package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Property;
import com.swe.lawnwebapp.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Methods for the property entity.
 */
@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * Returns all properties in the database.
     * @return list of properties.
     */
    public List<Property> getProperties(){
        return propertyRepository.findAll();
    }

    /**
     * Searches database for property by id.
     * @param id property id.
     * @return property if it exists in the database.
     */
    public Optional<Property> findById(int id){
        return propertyRepository.findById(id);
    }
}
