package com.hdc.lsy.bulider;

public abstract class ColdItem implements Item {

    public abstract float price();

    @Override
    public packing packing() {
        return new Upacking();
    }
}
