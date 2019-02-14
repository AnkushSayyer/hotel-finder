package com.hashmap.excercise.model;

import java.util.HashMap;
import java.util.Map;

public class RateCard {

    private Map<Category,Double> rateCard;

    public Map<Category, Double> generateRateCard(Price price){

        rateCard = new HashMap<Category, Double>();

        addRegularWeekdayPrice(regularWeekdayPrice);
        addRegularWeekendPrice(regularWeekendPrice);
        addRewardsWeekdayPrice(rewardsWeekdayPrice);
        addRewardsWeekendPrice(rewardsWeekendPrice);

        addCategoryAndRate(new Category(Customer.REWARDS, Day.WEEKEND), price.);

        return rateCard;
    }

    private void addCategoryAndRate(Category category, Double rate){

    }

    private void addRewardsWeekendPrice(double rewardsWeekendPrice) {
        rateCard.put(new Category(Customer.REWARDS, Day.WEEKEND), rewardsWeekendPrice);
    }

    private void addRewardsWeekdayPrice(double rewardsWeekdayPrice) {
        rateCard.put(new Category(Customer.REWARDS, Day.WEEKDAY), rewardsWeekdayPrice);
    }

    private void addRegularWeekendPrice(double regularWeekendPrice) {
        rateCard.put(new Category(Customer.REGULAR, Day.WEEKEND), regularWeekendPrice);
    }

    private void addRegularWeekdayPrice(double regularWeekdayPrice) {
        rateCard.put(new Category(Customer.REGULAR, Day.WEEKDAY), regularWeekdayPrice);
    }
}
