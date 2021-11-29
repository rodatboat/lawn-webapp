package com.swe.lawnwebapp.services;

import com.swe.lawnwebapp.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Methods for the images entity.
 */
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
}
