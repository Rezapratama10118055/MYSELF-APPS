package com.example.myselfapps.Daily;

public class itemModelTeman {


    private String nameteman,status;
    private int imagesteman;

    public itemModelTeman(String nameteman, String status, int imagesteman) {
        this.nameteman = nameteman;
        this.status = status;
        this.imagesteman = imagesteman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameteman() {
        return nameteman;
    }

    public void setNameteman(String nameteman) {
        this.nameteman = nameteman;
    }

    public int getImagesteman() {
        return imagesteman;
    }

    public void setImagesteman(int imagesteman) {
        this.imagesteman = imagesteman;
    }
}
