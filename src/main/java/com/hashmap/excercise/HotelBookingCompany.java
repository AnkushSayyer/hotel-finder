package com.hashmap.excercise;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class HotelBookingCompany implements BookingService {

    int weekends,weekdays;
    @Override
    public Hotel findCheapestHotel(Request clientRequest) {

        calculateWeekdaysAndWeekends(clientRequest.checkInDateString, clientRequest.checkOutDateString);

        HotelCatalogue hotelCatalogue = HotelCatalogue.getInstance();

        List<Hotel> hotelList = hotelCatalogue.getHotelList();

        double minPrice = getTotal(hotelList.get(0), clientRequest.customer);

        Hotel cheapestHotel = hotelList.get(0);

        for (int i=1; i<hotelList.size(); i++){
            double currentHotelPrice = getTotal(hotelList.get(i), clientRequest.customer);
            if(minPrice>currentHotelPrice){
                minPrice = currentHotelPrice;
                cheapestHotel = hotelList.get(i);
            }
            else if(minPrice==currentHotelPrice){
                if(cheapestHotel.getRating()<hotelList.get(i).getRating()){
                    minPrice = currentHotelPrice;
                    cheapestHotel = hotelList.get(i);
                }

            }


        }

        return cheapestHotel;
    }

    private void calculateWeekdaysAndWeekends(String checkInDateString, String checkOutDateString) {

        weekdays = 0;
        weekends = 0;

        LocalDate checkInDate = DateFromStringUtil.getDateFromString(checkInDateString);
        LocalDate checkOutDate = DateFromStringUtil.getDateFromString(checkOutDateString);

        LocalDate tempDate = checkInDate;
        LocalDate tempChkOutDate = checkOutDate.plusDays(1);

        if(!tempDate.equals(checkOutDate)){
            while (!tempDate.equals(tempChkOutDate)){


                if(tempDate.getDayOfWeek()== DayOfWeek.SATURDAY||tempDate.getDayOfWeek()==DayOfWeek.SUNDAY)
                    weekends++;
                else
                    weekdays++;

                tempDate = tempDate.plusDays(1);
            }
        }

    }

    private double getTotal(Hotel hotel, Customer customer){

        return hotel.getRate(new Category(customer, Day.WEEKDAYS))*weekdays +
                hotel.getRate(new Category(customer, Day.WEEKENDS))*weekends;

    }
}
