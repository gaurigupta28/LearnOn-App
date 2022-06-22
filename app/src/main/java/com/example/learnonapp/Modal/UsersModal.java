package com.example.learnonapp.Modal;

public class UsersModal {

     String ID;
     String NAME;
     String PHONE;
     String EMAIL;

     public UsersModal(String ID, String NAME, String PHONE, String EMAIL, String PASSWORD, String ADDRESS, String ROLLNO, String CLASS, String COLLAGE, String GENDER) {
          this.ID = ID;
          this.NAME = NAME;
          this.PHONE = PHONE;
          this.EMAIL = EMAIL;
          this.PASSWORD = PASSWORD;
          this.ADDRESS = ADDRESS;
          this.ROLLNO = ROLLNO;
          this.CLASS = CLASS;
          this.COLLAGE = COLLAGE;
          this.GENDER = GENDER;
     }

     String PASSWORD;
     String ADDRESS;
     String ROLLNO;
     String CLASS;
     String COLLAGE;
     String GENDER;




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

     public String getPASSWORD() {
          return PASSWORD;
     }

     public void setPASSWORD(String PASSWORD) {
          this.PASSWORD = PASSWORD;
     }

     public String getADDRESS() {
          return ADDRESS;
     }

     public void setADDRESS(String ADDRESS) {
          this.ADDRESS = ADDRESS;
     }

     public String getROLLNO() {
          return ROLLNO;
     }

     public void setROLLNO(String ROLLNO) {
          this.ROLLNO = ROLLNO;
     }

     public String getCLASS() {
          return CLASS;
     }

     public void setCLASS(String CLASS) {
          this.CLASS = CLASS;
     }

     public String getCOLLAGE() {
          return COLLAGE;
     }

     public void setCOLLAGE(String COLLAGE) {
          this.COLLAGE = COLLAGE;
     }

     public String getGENDER() {
          return GENDER;
     }

     public void setGENDER(String GENDER) {
          this.GENDER = GENDER;
     }

}
