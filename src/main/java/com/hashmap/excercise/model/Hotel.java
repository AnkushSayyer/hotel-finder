package com.hashmap.excercise.model;

import java.util.List;
import java.util.Map;

public class Hotel {

    private int rating;
    private String name;
    private List<Amenity> amenities;
    private int rooms;
    private int bookedRooms;

    private Map<Category,Double> rateCard;

    public Hotel(String name, HotelDetail hotelDetail, Map<Category, Double> rateCard){
        this.name = name;
        this.rating = hotelDetail.getRating();
        this.amenities = hotelDetail.getAmenities();
        this.rooms = hotelDetail.getRooms();
        this.rateCard = rateCard;
        bookedRooms = 0;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public Double getRate(Category category){
        return rateCard.get(category);
    }

    public int getRating(){
        return rating;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    public boolean areRoomsAvailable(int roomsWanted){
        if (rooms -bookedRooms >= roomsWanted)
            return true;
        else
            return false;
    }

    public void roomBooked(){
        bookedRooms++;
    }

    @Override
    public String toString() {
        return name;
    }



}
