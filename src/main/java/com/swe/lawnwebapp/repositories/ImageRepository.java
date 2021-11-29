package com.swe.lawnwebapp.repositories;

import com.swe.lawnwebapp.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Image repository, holds image entities.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
