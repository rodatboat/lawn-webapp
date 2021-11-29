package com.swe.lawnwebapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Property entity.
 */
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
    private float size; // in ft^2 or m^2
    public String address;

    @ManyToOne
    @JoinColumn(name="agentid", insertable=false, updatable=false)
    private Agent agent;

    @OneToMany(mappedBy = "property")
    private List<Image> images;

    public Property(int price, float size, String address, Agent agent) {
        this.price = price;
        this.size = size;
        this.address = address;
        this.agent = agent;
    }

    public List<Image> getImages(){
        return images;
    }
}
