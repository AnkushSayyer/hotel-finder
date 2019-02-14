package com.hashmap.excercise.service;

import com.hashmap.excercise.model.Request;
import com.hashmap.excercise.model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class HotelBookingCompany implements BookingService {

    private int weekends;
    private  int weekdays;
    private HotelCatalogue hotelCatalogue = HotelCatalogue.getInstance();
    private List<Hotel> hotelList = hotelCatalogue.getHotelList();

    @Override
    public Hotel getCheapestHotel(Request clientRequest) {
        calculateWeekdaysAndWeekends(clientRequest.getCheckInDate(), clientRequest.getCheckOutDate());
        return findCheapestHotel(clientRequest);
    }

    private Hotel findCheapestHotel(Request clientRequest){
        double minPrice = Double.MAX_VALUE;
        Hotel cheapestHotel = hotelList.get(0);

        for (Hotel currentHotel : hotelList) {
            double currentHotelPrice = getTotal(currentHotel, clientRequest.getCustomer());
            if (minPrice > currentHotelPrice ||
                    ((minPrice == currentHotelPrice) && (cheapestHotel.getRating() < currentHotel.getRating()))
            ) {
                minPrice = currentHotelPrice;
                cheapestHotel = currentHotel;
            }
        }
        return cheapestHotel;
    }

    private void calculateWeekdaysAndWeekends(LocalDate checkInDate, LocalDate checkOutDate) {
        weekdays = 0;
        weekends = 0;
        LocalDate tempDate = checkInDate;
        LocalDate tempChkOutDate = checkOutDate.plusDays(1);

        while (!tempDate.equals(tempChkOutDate)){
            if(tempDate.getDayOfWeek()== DayOfWeek.SATURDAY||tempDate.getDayOfWeek()==DayOfWeek.SUNDAY)
                weekends++;
            else
                weekdays++;
            tempDate = tempDate.plusDays(1);
        }
    }

    private double getTotal(Hotel hotel, Customer customer){
        return hotel.getRate(new Category(customer, Day.WEEKDAY))*weekdays +
                hotel.getRate(new Category(customer, Day.WEEKEND))*weekends;

    }
}
