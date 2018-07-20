package com.ultimatex.nsbm;

public class Subject {

    private String _id;
    private String name;
    private int price;

    public Subject(String name,int price) {

        this.name=name;
        this.price=price;

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
