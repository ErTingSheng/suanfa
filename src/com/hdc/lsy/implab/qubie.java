package com.hdc.lsy.implab;

public abstract class qubie {
    qubie(){
    }
    protected abstract void test();
    public void tex(){
        System.out.println("tex");
    }
}
class lll extends qubie{
    lll(){
    }
    public void test() {
    }
}
class ttt{
    public static void main(String[] args) {
        qubie lll = new lll();
//        qubie qubie = new qubie();
//        qubieinter qubieinter = new qubieinter();
//        qubieinter.test();
        lll.tex();
    }
}
