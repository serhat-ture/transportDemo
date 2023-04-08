package com.serhat.transportdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable( name = "routeee_stationss",
           joinColumns=  {@JoinColumn(name = "stations_id",referencedColumnName = "id")} ,
         inverseJoinColumns = {@JoinColumn(name = "routes_id",referencedColumnName = "id")})
    private Set<Route> routes = new HashSet<>();


}
