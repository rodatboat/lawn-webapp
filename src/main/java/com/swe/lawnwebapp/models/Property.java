package com.swe.lawnwebapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

//    @ManyToMany(mappedBy = "watchlist")
//    private List<User> watchers;

    public List<Image> getImages(){
        return images;
    }
}
