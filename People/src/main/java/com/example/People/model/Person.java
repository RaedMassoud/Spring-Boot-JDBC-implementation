package com.example.People.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // -> Handel object creation, managing, and destruction.
@Scope("prototype") // -> Default: singleton
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  "Id: " + id + ", "
                + "Name: " + firstName + " " + lastName + ", "
                + "City: " + city + "\n";
    }
}
