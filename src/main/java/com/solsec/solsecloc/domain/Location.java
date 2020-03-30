package com.solsec.solsecloc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String cityName;
    @NotNull
    private String address;
    @NotNull
    private String coordinates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", address='" + address + '\'' +
                ", coordinates='" + coordinates + '\'' +
                '}';
    }
}
