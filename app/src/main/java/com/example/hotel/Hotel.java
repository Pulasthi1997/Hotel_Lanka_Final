package com.example.hotel;

public class Hotel {

    String mHid;
    String mHName;
    String mHAddress;
    String mHPhone;
    String mHPrice;
    String mHClass;
    String mHFacilites;
    String mHOwner;
    String mHWeb;

    public Hotel() {
    }

    public Hotel(String mHid, String mHName, String mHAddress, String mHPhone, String mHPrice, String mHClass, String mHFacilites, String mHOwner, String mHWeb) {
        this.mHid = mHid;
        this.mHName = mHName;
        this.mHAddress = mHAddress;
        this.mHPhone = mHPhone;
        this.mHPrice = mHPrice;
        this.mHClass = mHClass;
        this.mHFacilites = mHFacilites;
        this.mHOwner = mHOwner;
        this.mHWeb = mHWeb;
    }

    public String getmHOwner() {
        return mHOwner;
    }

    public void setmHOwner(String mHOwner) {
        this.mHOwner = mHOwner;
    }

    public String getmHWeb() {
        return mHWeb;
    }

    public void setmHWeb(String mHWeb) {
        this.mHWeb = mHWeb;
    }

    public String getmHid() {
        return mHid;
    }

    public void setmHid(String mHid) {
        this.mHid = mHid;
    }

    public String getmHName() {
        return mHName;
    }

    public void setmHName(String mHName) {
        this.mHName = mHName;
    }

    public String getmHAddress() {
        return mHAddress;
    }

    public void setmHAddress(String mHAddress) {
        this.mHAddress = mHAddress;
    }

    public String getmHPhone() {
        return mHPhone;
    }

    public void setmHPhone(String mHPhone) {
        this.mHPhone = mHPhone;
    }

    public String getmHPrice() {
        return mHPrice;
    }

    public void setmHPrice(String mHPrice) {
        this.mHPrice = mHPrice;
    }

    public String getmHClass() {
        return mHClass;
    }

    public void setmHClass(String mHClass) {
        this.mHClass = mHClass;
    }

    public String getmHFacilites() {
        return mHFacilites;
    }

    public void setmHFacilites(String mHFacilites) {
        this.mHFacilites = mHFacilites;
    }
}
