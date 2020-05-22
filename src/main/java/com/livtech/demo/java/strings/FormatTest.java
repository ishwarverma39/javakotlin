package com.livtech.demo.java.strings;

public class FormatTest {
    static String pattern = "<a href=\"%1$s\">Join %2$s ID:%3$s </a>";

    public static void main(String[] args) {
        System.out.println(String.format(pattern, "a", "b", "c"));
    }
}
