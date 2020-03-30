package com.solsec.solsecloc.transfer.response;


public class LocationResponse {

    private Long id;
    private String cityName;
    private String address;
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
