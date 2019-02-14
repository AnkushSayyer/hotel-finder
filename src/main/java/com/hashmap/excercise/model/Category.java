package com.hashmap.excercise.model;

public class Category {

    Customer customerType;
    Day day;

    public Category(Customer customerType, Day day){
        this.customerType = customerType;
        this.day = day;
    }

    @Override
    public boolean equals(Object categoryObj)
    {

        if(this == categoryObj)
            return true;

        if(categoryObj == null || categoryObj.getClass()!= this.getClass())
            return false;

        Category category = (Category) categoryObj;

        return (category.customerType.equals(this.customerType)  && category.day == this.day);
    }

    @Override
    public int hashCode()
    {
        return (int)(this.customerType.toString().charAt(2)) + (int)(this.day.toString().charAt(this.day.toString().length()-2));
    }

}
