package com.swe.lawnwebapp.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int property_id;


    @ManyToOne
    @JoinColumn(name="userid", insertable=false, updatable=false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
