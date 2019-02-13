package com.hashmap.excercise;

public class Request {
    Customer customer;
    String checkInDateString;
    String checkOutDateString;

    public Request(Customer customer, String checkInDateString, String checkOutDateString){

        this.customer = customer;
        this.checkInDateString = checkInDateString;
        this.checkOutDateString = checkOutDateString;

    }
}
