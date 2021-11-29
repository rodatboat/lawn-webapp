package com.swe.lawnwebapp.repositories;

import com.swe.lawnwebapp.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Favorite repository, holds favorite entities.
 */
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}
