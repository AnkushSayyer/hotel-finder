package com.hashmap.excercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CustomerRequirement {
    private int roomsRequired;
    private List<Amenity> amenitiesRequired;
}
