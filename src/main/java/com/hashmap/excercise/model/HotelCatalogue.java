package com.hashmap.excercise.model;

import java.util.ArrayList;
import java.util.Map;

public class HotelCatalogue {
    private ArrayList<Hotel> hotelList;
    private static HotelCatalogue hotelCatalogue;

    private HotelCatalogue() {
        hotelList = new ArrayList<>();
    }

    public synchronized static HotelCatalogue getInstance() {
            if (hotelCatalogue == null)
                hotelCatalogue = new HotelCatalogue();
            return hotelCatalogue;
    }

    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }

    public void addHotel(String name, int rating, Price price){
        Map<Category, Double> rateCard = new RateCard().generateRateCard(price);
        hotelList.add(new Hotel(name, rating, rateCard));
    }

}
