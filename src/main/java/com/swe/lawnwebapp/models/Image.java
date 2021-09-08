package com.swe.lawnwebapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String image_url;

    @ManyToOne
    @JoinColumn(name="propertyid", insertable=false, updatable=false)
    private Property property;
}
