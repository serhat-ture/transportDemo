package com.serhat.transportdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


/*
In this implementation, we have three entities:
        Route, Station, and Vehicle.
        The Route entity has a one-to-many relationship with both Station and Vehicle,
        while both Station and Vehicle have a many-to-one relationship with Route.*/

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String source;
    private String destination;

    @JsonIgnore
    @ManyToMany(mappedBy = "routes")
    private Set<Station> stations = new HashSet<>();







    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vehicle> vehicle = new HashSet<>();

}
