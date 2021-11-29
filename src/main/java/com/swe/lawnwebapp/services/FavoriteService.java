package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Favorite;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Methods for the favorites entity.
 */
@Service
public class FavoriteService {
    
    @Autowired
    private FavoriteRepository favoriteRepository;

    /**
     * Returns all fovirties in the database.
     * @return list of favorites.
     */
    public List<Favorite> getProperties(){
        return favoriteRepository.findAll();
    }

    /**
     * Finds favorite listing by id.
     * @param id favorite listing id.
     * @return the favorite listing, if it exists.
     */
    public Optional<Favorite> findById(int id){
        return favoriteRepository.findById(id);
    }

    /**
     * Saves favorite listing to database.
     * @param fav the favorite listing.
     */
    public void save(Favorite fav){
        User user = fav.getUser();
        int prop_id = fav.getProperty_id();

        boolean favExists = false;
        for(Favorite favorite : user.getFavorites()){
            if(favorite.getProperty_id() == prop_id){
                favExists = true;
                break;
            }
        }

        if(!favExists)
            favoriteRepository.save(fav);
    }

    /**
     * Deletes favorite listing from database.
     * @param id the favorite listing id.
     */
    public void delete(Integer id){
        favoriteRepository.deleteById(id);
    }
}
