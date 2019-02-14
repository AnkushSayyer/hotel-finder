package com.hashmap.excercise.model;

import java.util.HashMap;
import java.util.Map;

public class RateCard {

    private Map<Category,Double> rateCard;

    public Map<Category, Double> generateRateCard(Price price){
        rateCard = new HashMap<Category, Double>();
        addRegularCustomerRates(price);
        addRewardCustomerRate(price);
        return rateCard;
    }

    private void addRegularCustomerRates(Price price) {
        addCategoryAndRateToRateCard(new Category(Customer.REGULAR, Day.WEEKDAY), price.getRegularWeekdayPrice());
        addCategoryAndRateToRateCard(new Category(Customer.REGULAR, Day.WEEKEND), price.getRegularWeekendPrice());
    }

    private void addRewardCustomerRate(Price price) {
        addCategoryAndRateToRateCard(new Category(Customer.REWARDS, Day.WEEKEND), price.getRewardsWeekendPrice());
        addCategoryAndRateToRateCard(new Category(Customer.REWARDS, Day.WEEKDAY), price.getRewardsWeekdayPrice());
    }

    private void addCategoryAndRateToRateCard(Category category, Double rate){
        rateCard.put(category, rate);
    }

}
