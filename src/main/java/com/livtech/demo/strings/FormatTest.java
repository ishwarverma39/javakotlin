package com.livtech.demo.strings;

import java.util.Locale;
import java.util.regex.Pattern;

public class FormatTest {
    static String pattern = "<a href=\"%1$s\">Join %2$s ID:%3$s </a>";

    public static void main(String[] args) {
        System.out.println(String.format(pattern, "a", "b", "c"));
    }
}
