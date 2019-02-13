import com.hashmap.excercise.model.Customer;
import com.hashmap.excercise.model.HotelCatalogue;
import com.hashmap.excercise.model.Request;
import com.hashmap.excercise.service.HotelBookingCompany;
import com.hashmap.excercise.util.DateFromStringUtil;
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
        Assert.assertEquals("LakeWood", hotelBookingCompany.findCheapestHotel(new Request(Customer.REGULAR, DateFromStringUtil.getDateFromString("16/3/2009"), DateFromStringUtil.getDateFromString("18/3/2009"))).toString());
    }

    @Test
    public void hotelFinderTest2(){
        Assert.assertEquals("BridgeWood", hotelBookingCompany.findCheapestHotel(new Request(Customer.REGULAR, DateFromStringUtil.getDateFromString("20/3/2009"), DateFromStringUtil.getDateFromString("22/3/2009"))).toString());
    }

    @Test
    public void hotelFinderTest3(){
        Assert.assertEquals("RidgeWood", hotelBookingCompany.findCheapestHotel(new Request(Customer.REWARDS, DateFromStringUtil.getDateFromString("26/3/2009"), DateFromStringUtil.getDateFromString("28/3/2009"))).toString());
    }

}
