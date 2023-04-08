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
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable( name = "route_stations",
           joinColumns=  {@JoinColumn(name = "station_id",referencedColumnName = "id")} ,
         inverseJoinColumns = {@JoinColumn(name = "route_id",referencedColumnName = "id")})
    private Set<Route> route = new HashSet<>();


}
