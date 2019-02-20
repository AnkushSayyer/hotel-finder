package com.hashmap.excercise.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Request {
    private Customer customer;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private CustomerRequirement customerRequirement;

    public Request(Customer customer, LocalDate checkInDate, LocalDate checkOutDate, CustomerRequirement customerRequirement) {
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerRequirement = customerRequirement;
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
