package com.livtech.demo.java.interfaces;

public class UseInterfaceA {
    A a;

    public UseInterfaceA(A a) {
        this.a = a;
    }

    public void show() {
        a.show();
    }
}
