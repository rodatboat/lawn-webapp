package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.models.Favorite;
import com.swe.lawnwebapp.models.User;
import com.swe.lawnwebapp.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> getProperties(){
        return favoriteRepository.findAll();
    }

    public Optional<Favorite> findById(int id){
        return favoriteRepository.findById(id);
    }

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

    public void delete(Integer id){
        favoriteRepository.deleteById(id);
    }
}
