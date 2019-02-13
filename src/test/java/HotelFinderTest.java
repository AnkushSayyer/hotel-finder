import com.hashmap.excercise.Customer;
import com.hashmap.excercise.HotelBookingCompany;
import com.hashmap.excercise.HotelCatalogue;
import com.hashmap.excercise.Request;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelFinderTest {

    private HotelCatalogue hotelCatalogue;
    private HotelBookingCompany hotelBookingCompany;
    private static boolean initialized = false;

    @Before
    public void init() {
        hotelBookingCompany = new HotelBookingCompany();

        hotelCatalogue = HotelCatalogue.getInstance();

        if (!initialized){

            hotelCatalogue.addHotel("LakeWood", 3, 110, 90, 80, 80);
            hotelCatalogue.addHotel("BridgeWood", 4, 160, 60, 110, 50);
            hotelCatalogue.addHotel("RidgeWood", 5, 220, 150, 100, 40);

            initialized = true;
        }

    }

    @Test
    public void hotelFinderTest(){
        Assert.assertEquals("LakeWood", hotelBookingCompany.findCheapestHotel(new Request(Customer.REGULAR, "16/3/2009", "18/3/2009")).toString());
    }

    @Test
    public void hotelFinderTest2(){
        Assert.assertEquals("BridgeWood", hotelBookingCompany.findCheapestHotel(new Request(Customer.REGULAR, "20/3/2009", "22/3/2009")).toString());
    }

    @Test
    public void hotelFinderTest3(){
        Assert.assertEquals("RidgeWood", hotelBookingCompany.findCheapestHotel(new Request(Customer.REWARDS, "26/3/2009", "28/3/2009")).toString());
    }

}
