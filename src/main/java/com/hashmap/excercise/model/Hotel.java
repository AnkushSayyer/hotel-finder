package com.hashmap.excercise.model;

import com.hashmap.excercise.model.Category;

import java.util.Map;

public class Hotel {

    private int rating;
    private String name;

    private Map<Category,Double> rateCard;

    public Hotel(String name, int rating, Map<Category, Double> rateCard){
        this.name = name;
        this.rating = rating;
        this.rateCard = rateCard;
    }

    public Double getRate(Category category){
        return rateCard.get(category);
    }

    public int getRating(){
        return rating;
    }

    @Override
    public String toString() {
        return name;
    }



}
