package com.vicarry.vicarryproject.ui.truckowner.model;

public class OrderHistoryObject {
    String idOHO;
    String priceOHO;
    String addressFromOHO;
    String addressToOHO;
    String timeOHO;
    String massOHO;
    String productOHO;
    boolean statusOHO;

    public OrderHistoryObject(String idOHO, String priceOHO, String addressFromOHO, String addressToOHO, String timeOHO, String massOHO, String productOHO, boolean statusOHO) {
        this.idOHO = idOHO;
        this.priceOHO = priceOHO;
        this.addressFromOHO = addressFromOHO;
        this.addressToOHO = addressToOHO;
        this.timeOHO = timeOHO;
        this.massOHO = massOHO;
        this.productOHO = productOHO;
        this.statusOHO = statusOHO;
    }

    public String getIdOHO() {
        return idOHO;
    }

    public void setIdOHO(String idOHO) {
        this.idOHO = idOHO;
    }

    public String getPriceOHO() {
        return priceOHO;
    }

    public void setPriceOHO(String priceOHO) {
        this.priceOHO = priceOHO;
    }

    public String getAddressFromOHO() {
        return addressFromOHO;
    }

    public void setAddressFromOHO(String addressFromOHO) {
        this.addressFromOHO = addressFromOHO;
    }

    public String getAddressToOHO() {
        return addressToOHO;
    }

    public void setAddressToOHO(String addressToOHO) {
        this.addressToOHO = addressToOHO;
    }

    public String getTimeOHO() {
        return timeOHO;
    }

    public void setTimeOHO(String timeOHO) {
        this.timeOHO = timeOHO;
    }

    public String getMassOHO() {
        return massOHO;
    }

    public void setMassOHO(String massOHO) {
        this.massOHO = massOHO;
    }

    public String getProductOHO() {
        return productOHO;
    }

    public void setProductOHO(String productOHO) {
        this.productOHO = productOHO;
    }

    public boolean isStatusOHO() {
        return statusOHO;
    }

    public void setStatusOHO(boolean statusOHO) {
        this.statusOHO = statusOHO;
    }
}
