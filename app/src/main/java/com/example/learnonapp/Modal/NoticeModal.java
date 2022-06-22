package com.example.learnonapp.Modal;

public class NoticeModal {

    private String NOTICEID;
    private String NOTICE;
    private String FULLDESCRIPTION;
    private String ISACTIVE;

    public NoticeModal(String NOTICE, String FULLDESCRIPTION) {
        this.NOTICE = NOTICE;
        this.FULLDESCRIPTION = FULLDESCRIPTION;
    }





    public String getNOTICEID() {
        return NOTICEID;
    }

    public void setNOTICEID(String NOTICEID) {
        this.NOTICEID = NOTICEID;
    }

    public String getNOTICE() {
        return NOTICE;
    }

    public void setNOTICE(String NOTICE) {
        this.NOTICE = NOTICE;
    }

    public String getFULLDESCRIPTION() {
        return FULLDESCRIPTION;
    }

    public void setFULLDESCRIPTION(String FULLDESCRIPTION) {
        this.FULLDESCRIPTION = FULLDESCRIPTION;
    }

    public String getISACTIVE() {
        return ISACTIVE;
    }

    public void setISACTIVE(String ISACTIVE) {
        this.ISACTIVE = ISACTIVE;
    }


}
