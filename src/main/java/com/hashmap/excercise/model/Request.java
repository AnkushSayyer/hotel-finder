package com.hashmap.excercise.model;

import com.hashmap.excercise.model.Customer;

import java.time.LocalDate;

public class Request {
    private Customer customer;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Request(Customer customer, LocalDate checkInDate, LocalDate checkOutDate){

        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}
