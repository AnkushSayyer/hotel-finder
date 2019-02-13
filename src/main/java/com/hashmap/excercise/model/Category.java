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

        // if both the object references are
        // referring to the same object.
        if(this == categoryObj)
            return true;

        // it checks if the argument is of the
        // type Category by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Category)) return false; ---> avoid.
        if(categoryObj == null || categoryObj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        Category category = (Category) categoryObj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (category.customerType.equals(this.customerType)  && category.day == this.day);
    }

    @Override
    public int hashCode()
    {

        // We are returning the Geek_id
        // as a hashcode value.
        // we can also return some
        // other calculated value or may
        // be memory address of the
        // Object on which it is invoked.
        // it depends on how you implement
        // hashCode() method.

        return (int)(this.customerType.toString().charAt(2)) + (int)(this.day.toString().charAt(this.day.toString().length()-2));
        //return this.id;
    }

}
