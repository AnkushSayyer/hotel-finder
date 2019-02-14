package com.hashmap.excercise.model;

import java.util.ArrayList;
import java.util.Map;

public class HotelCatalogue {

    private ArrayList<Hotel> hotelList;

    private static HotelCatalogue hotelCatalogue;

    /*public HotelCatalogue(){
        hotelList = new ArrayList<>();
    }*/

    private HotelCatalogue() {
        hotelList = new ArrayList<>();
    }

    public synchronized static HotelCatalogue getInstance()
    {
            if (hotelCatalogue == null)
                hotelCatalogue = new HotelCatalogue();
            return hotelCatalogue;

    }

    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }

    public void addHotel(String name, int rating, double regularWeekdayPrice, double regularWeekendPrice, double rewardsWeekdayPrice, double rewardsWeekendPrice){

        Map<Category, Double> rateCard = new RateCard().generateRateCard(regularWeekdayPrice, regularWeekendPrice, rewardsWeekdayPrice, rewardsWeekendPrice);
        hotelList.add(new Hotel(name, rating, rateCard));
    }

}
