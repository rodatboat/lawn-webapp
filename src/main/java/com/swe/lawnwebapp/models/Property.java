package com.swe.lawnwebapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    // Property(int id, int price, int area, string address, string img_url, int agent_id)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int price;
    private int area; // in ft^2 or m^2
    private String address;
    private String img_url;

    private int agent_id;
}
