package com.example.hotel;

public class Crew {

    String mId;
    String mName;
    String mAddress;
    String mNIC;
    String mPhone;
    String mStatus;
    String mEmail;
    String mPassword;

    public Crew() {
    }

    public Crew(String mId, String mName, String mAddress, String mNIC, String mPhone, String mStatus, String mEmail, String mPassword) {
        this.mId = mId;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mNIC = mNIC;
        this.mPhone = mPhone;
        this.mStatus = mStatus;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmNIC() {
        return mNIC;
    }

    public void setmNIC(String mNIC) {
        this.mNIC = mNIC;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
