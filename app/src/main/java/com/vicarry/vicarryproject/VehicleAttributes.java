package com.vicarry.vicarryproject;

public class VehicleAttributes {
    private String vehicleCategory;
    private String weight, lenght, width, height;
    private String licensePlates;

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public VehicleAttributes(String vehicleCategory, String weight, String lenght, String width, String height, String licensePlates) {
        this.vehicleCategory = vehicleCategory;
        this.weight = weight;
        this.lenght = lenght;
        this.width = width;
        this.height = height;
        this.licensePlates = licensePlates;
    }
}
