package com.example.learnonapp.Modal;

public class TimeTableModal {

    public TimeTableModal(String FILENAME, String FILE) {
        this.FILENAME = FILENAME;
        this.FILE = FILE;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public String getFILE() {
        return FILE;
    }

    public void setFILE(String FILE) {
        this.FILE = FILE;
    }

    String FILENAME, FILE;

}
