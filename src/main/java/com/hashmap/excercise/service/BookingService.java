package com.hashmap.excercise.service;

import com.hashmap.excercise.model.Request;
import com.hashmap.excercise.model.Hotel;

public interface BookingService {

    Hotel getCheapestHotel(Request clientRequest);

}
