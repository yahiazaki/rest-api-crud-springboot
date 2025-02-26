package com.example.aspectlab1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;
    private String street;
    private String postcode;

    public address(Integer number, String street, String postcode) {
        this.number = number;
        this.street = street;
        this.postcode = postcode;
    }

    public address() {}


    public Integer getId() {
        return id;
    }
    public Integer getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }
    public String getPostcode() {
        return postcode;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
