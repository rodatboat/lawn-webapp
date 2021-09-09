package com.swe.lawnwebapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String password;

    // User(int id, string username, string password, boolean admin_permissions, int favorites/watchlist)
}