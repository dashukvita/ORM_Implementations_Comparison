package ru.jpa.tests.TestCollectionPerson.model;

import ru.helpclasses.Randomizer;

import javax.persistence.Embeddable;

@Embeddable
public class AddressCollection {
    private String street;
    private String city;
    private String zip;
    private String country;

    public AddressCollection(){
        street = Randomizer.randomStreet();
        city = Randomizer.randomCity();
        zip = Randomizer.randomZip();
        country = Randomizer.randomCountry();
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return country;
    }
    public void setState(String state) {
        this.country = state;
    }

    @Override
    public String toString() {
        return
                " street = " + street +
                " city = " + city +
                " zip = " + zip +
                " country = " + country;
    }

}
