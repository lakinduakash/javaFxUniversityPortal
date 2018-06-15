package com.ultimatex.nsbm;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("address")
public class AddressTest {
    @Id
    private ObjectId id;
    private String city;
    private String street;

    public AddressTest(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public AddressTest() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
