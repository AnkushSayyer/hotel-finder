package com.hashmap.excercise.model;


public class Price {
    private double regularWeekdayPrice;
    private double regularWeekendPrice;
    private double rewardsWeekdayPrice;
    private double rewardsWeekendPrice;

    public Price(double regularWeekdayPrice, double regularWeekendPrice, double rewardsWeekdayPrice, double rewardsWeekendPrice) {
        this.regularWeekdayPrice = regularWeekdayPrice;
        this.regularWeekendPrice = regularWeekendPrice;
        this.rewardsWeekdayPrice = rewardsWeekdayPrice;
        this.rewardsWeekendPrice = rewardsWeekendPrice;
    }

    public double getRegularWeekdayPrice() {
        return regularWeekdayPrice;
    }

    public double getRegularWeekendPrice() {
        return regularWeekendPrice;
    }

    public double getRewardsWeekdayPrice() {
        return rewardsWeekdayPrice;
    }

    public double getRewardsWeekendPrice() {
        return rewardsWeekendPrice;
    }
}
