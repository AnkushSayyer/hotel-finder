package service;

import com.hashmap.excercise.model.*;
import com.hashmap.excercise.service.HotelBookingCompany;
import com.hashmap.excercise.util.DateFromStringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class HotelFinderTest {

    private HotelCatalogue hotelCatalogue;
    private HotelBookingCompany hotelBookingCompany;
    private static boolean initialized = false;

    @Before
    public void init() {
        hotelBookingCompany = new HotelBookingCompany();

        hotelCatalogue = HotelCatalogue.getInstance();

        if (!initialized){
            hotelCatalogue.addHotel("LakeWood", new HotelDetail(3, Arrays.asList(Amenity.WIFI, Amenity.MEALS), 3), new Price(110, 90, 80, 80));
            hotelCatalogue.addHotel("BridgeWood", new HotelDetail(3, Arrays.asList(Amenity.WIFI, Amenity.MEALS, Amenity.SWIMMING_POOL), 4), new Price(160, 60, 110, 50));
            hotelCatalogue.addHotel("RidgeWood", new HotelDetail(3, Arrays.asList(Amenity.WIFI, Amenity.MEALS, Amenity.SWIMMING_POOL, Amenity.BAR), 4), new Price(220, 150, 100, 40));

            initialized = true;
        }

    }

    @Test
    public void hotelFinderTest(){
        Hotel actualHotelValue = hotelBookingCompany.getCheapestHotel(new Request(Customer.REGULAR, DateFromStringUtil.getDateFromString("16/3/2009"), DateFromStringUtil.getDateFromString("18/3/2009"), new CustomerRequirement(2, Arrays.asList(Amenity.SWIMMING_POOL))));
        actualHotelValue.roomBooked();
        Assert.assertEquals("LakeWood", actualHotelValue.toString());
    }

    @Test
    public void hotelFinderTest2(){
        Assert.assertEquals("BridgeWood", hotelBookingCompany.getCheapestHotel(new Request(Customer.REGULAR, DateFromStringUtil.getDateFromString("20/3/2009"), DateFromStringUtil.getDateFromString("22/3/2009"), new CustomerRequirement(1, Arrays.asList(Amenity.SWIMMING_POOL, Amenity.MEALS)))).toString());
    }

    @Test
    public void hotelFinderTest3(){
        Assert.assertEquals("RidgeWood", hotelBookingCompany.getCheapestHotel(new Request(Customer.REWARDS, DateFromStringUtil.getDateFromString("26/3/2009"), DateFromStringUtil.getDateFromString("28/3/2009"), new CustomerRequirement(2, Arrays.asList(Amenity.WIFI, Amenity.BAR)))).toString());
    }

}
