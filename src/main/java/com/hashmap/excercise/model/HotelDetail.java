package com.hashmap.excercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class HotelDetail {
    private int rating;
    private List<Amenity> amenities;
    private int rooms;
}
