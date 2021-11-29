package com.swe.lawnwebapp.repositories;

import com.swe.lawnwebapp.models.Property;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Property repository, holds property entities.
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
