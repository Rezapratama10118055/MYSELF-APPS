package com.example.myselfapps.Daily;

public class itemModel {
    private String Name,waktu;
    private int images;

    //03/06/2021, 10118055, Reza Pratama, If-2


    public itemModel(String name, String waktu, int images) {
        Name = name;
        this.waktu = waktu;
        this.images = images;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
