package com.vicarry.vicarryproject.ui.truckowner.model;

public class CompletedApplicationObject {
    String timeCAO;
    String cityCAO;
    String timeFromCAO;
    String timeToCAO;
    String nameVehicleCAO;
    String licensePlatesCAO;
    String nameCAO;
    String phoneNumeberCAO;
    int statusCAO;

    public CompletedApplicationObject(String timeCAO, String cityCAO, String timeFromCAO, String timeToCAO, String nameVehicleCAO, String licensePlatesCAO, String nameCAO, String phoneNumeberCAO, int statusCAO) {
        this.timeCAO = timeCAO;
        this.cityCAO = cityCAO;
        this.timeFromCAO = timeFromCAO;
        this.timeToCAO = timeToCAO;
        this.nameVehicleCAO = nameVehicleCAO;
        this.licensePlatesCAO = licensePlatesCAO;
        this.nameCAO = nameCAO;
        this.phoneNumeberCAO = phoneNumeberCAO;
        this.statusCAO = statusCAO;
    }

    public String getTimeCAO() {
        return timeCAO;
    }

    public void setTimeCAO(String timeCAO) {
        this.timeCAO = timeCAO;
    }

    public String getCityCAO() {
        return cityCAO;
    }

    public void setCityCAO(String cityCAO) {
        this.cityCAO = cityCAO;
    }

    public String getTimeFromCAO() {
        return timeFromCAO;
    }

    public void setTimeFromCAO(String timeFromCAO) {
        this.timeFromCAO = timeFromCAO;
    }

    public String getTimeToCAO() {
        return timeToCAO;
    }

    public void setTimeToCAO(String timeToCAO) {
        this.timeToCAO = timeToCAO;
    }

    public String getNameVehicleCAO() {
        return nameVehicleCAO;
    }

    public void setNameVehicleCAO(String nameVehicleCAO) {
        this.nameVehicleCAO = nameVehicleCAO;
    }

    public String getLicensePlatesCAO() {
        return licensePlatesCAO;
    }

    public void setLicensePlatesCAO(String licensePlatesCAO) {
        this.licensePlatesCAO = licensePlatesCAO;
    }

    public String getNameCAO() {
        return nameCAO;
    }

    public void setNameCAO(String nameCAO) {
        this.nameCAO = nameCAO;
    }

    public String getPhoneNumeberCAO() {
        return phoneNumeberCAO;
    }

    public void setPhoneNumeberCAO(String phoneNumeberCAO) {
        this.phoneNumeberCAO = phoneNumeberCAO;
    }

    public int getStatusCAO() {
        return statusCAO;
    }

    public void setStatusCAO(int statusCAO) {
        this.statusCAO = statusCAO;
    }
}
