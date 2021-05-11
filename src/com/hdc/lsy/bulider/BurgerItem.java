package com.hdc.lsy.bulider;
public abstract class BurgerItem implements Item{
    public packing packing(){
        return new WrapperPacking();
    }
    public abstract float price();
}
