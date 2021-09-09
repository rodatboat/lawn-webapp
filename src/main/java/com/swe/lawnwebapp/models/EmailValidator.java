package com.swe.lawnwebapp.models;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String test){
        // TODO: Regex to validate
        return true;
    }
}
