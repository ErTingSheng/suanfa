package com.hdc.lsy.test;

public class lll {
    lll() {
        System.out.println("111");
    }
    lll(int a) {
        System.out.println(a);
    }
    static class aaa extends lll{
        aaa() {
            System.out.println("aaa");
        }
        aaa(int a) {
            System.out.println(a);
        }

        public static void main(String[] args) {
            aaa aaa = new aaa(2);
        }
    }
}
