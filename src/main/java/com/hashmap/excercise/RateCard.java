package com.hashmap.excercise;

import java.util.HashMap;
import java.util.Map;

public class RateCard {

    private static Map<Category,Double> rateCard;

    public static Map<Category, Double> generateRateCard(double regularWeekdayPrice, double regularWeekendPrice, double rewardsWeekdayPrice, double rewardsWeekendPrice){

        rateCard = new HashMap<Category, Double>();

        addRegularWeekdayPrice(regularWeekdayPrice);
        addRegularWeekendPrice(regularWeekendPrice);
        addRewardsWeekdayPrice(rewardsWeekdayPrice);
        addRewardsWeekendPrice(rewardsWeekendPrice);

        return rateCard;
    }

    private static void addRewardsWeekendPrice(double rewardsWeekendPrice) {
        rateCard.put(new Category(Customer.REWARDS, Day.WEEKENDS), rewardsWeekendPrice);
    }

    private static void addRewardsWeekdayPrice(double rewardsWeekdayPrice) {
        rateCard.put(new Category(Customer.REWARDS, Day.WEEKDAYS), rewardsWeekdayPrice);
    }

    private static void addRegularWeekendPrice(double regularWeekendPrice) {
        rateCard.put(new Category(Customer.REGULAR, Day.WEEKENDS), regularWeekendPrice);
    }

    private static void addRegularWeekdayPrice(double regularWeekdayPrice) {
        rateCard.put(new Category(Customer.REGULAR, Day.WEEKDAYS), regularWeekdayPrice);
    }
}
