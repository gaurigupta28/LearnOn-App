package com.example.learnonapp.Modal;

public class AdminModal {


    String ID;
    String NAME;
    String PHONE;
    String EMAIL;
    String PASSWORD;

    public AdminModal(String ID, String NAME, String PHONE, String EMAIL, String PASSWORD) {
        this.ID = ID;
        this.NAME = NAME;
        this.PHONE = PHONE;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
    }
    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }


}
