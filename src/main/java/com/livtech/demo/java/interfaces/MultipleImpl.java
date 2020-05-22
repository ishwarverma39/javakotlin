package com.livtech.demo.java.interfaces;

public class MultipleImpl implements A, B {
    @Override
    public void show() {
        System.out.println("Show called " + this.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        MultipleImpl multiple = new MultipleImpl();
        new UseInterfaceA(multiple).show();
        new UserInterfaceB(multiple).show();
    }
}
