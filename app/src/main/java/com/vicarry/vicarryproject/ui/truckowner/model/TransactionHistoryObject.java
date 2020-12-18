package com.vicarry.vicarryproject.ui.truckowner.model;

public class TransactionHistoryObject {
    String timeTHO;
    String bankCodeTHO;
    String codeTHO;
    String priceTHO;
    int statusTHO;

    public TransactionHistoryObject(String timeTHO, String bankCodeTHO, String codeTHO, String priceTHO, int statusTHO) {
        this.timeTHO = timeTHO;
        this.bankCodeTHO = bankCodeTHO;
        this.codeTHO = codeTHO;
        this.priceTHO = priceTHO;
        this.statusTHO = statusTHO;
    }

    public String getTimeTHO() {
        return timeTHO;
    }

    public void setTimeTHO(String timeTHO) {
        this.timeTHO = timeTHO;
    }

    public String getBankCodeTHO() {
        return bankCodeTHO;
    }

    public void setBankCodeTHO(String bankCodeTHO) {
        this.bankCodeTHO = bankCodeTHO;
    }

    public String getCodeTHO() {
        return codeTHO;
    }

    public void setCodeTHO(String codeTHO) {
        this.codeTHO = codeTHO;
    }

    public String getPriceTHO() {
        return priceTHO;
    }

    public void setPriceTHO(String priceTHO) {
        this.priceTHO = priceTHO;
    }

    public int getStatusTHO() {
        return statusTHO;
    }

    public void setStatusTHO(int statusTHO) {
        this.statusTHO = statusTHO;
    }
}
