package com.livtech.demo.java.interfaces;

public class UserInterfaceB {
    B b;

    public UserInterfaceB(B b) {
        this.b = b;
    }

    void show() {
        b.show();
    }
}
