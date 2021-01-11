package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        IntSet a = new EmptySet();
        System.out.println(a.toString());

        a=a.add(12);
        System.out.println(a.toString());

        a=a.add(12);                    // NO DUPLICATES OCCURING
        System.out.println(a.toString());

        a=a.add(13);
        System.out.println(a.toString());

        a=a.add((14));
        System.out.println(a.toString());

        a=a.add(15);
        System.out.println(a.toString());

        a=a.add(16);
        System.out.println(a.toString());


        IntSet b=a.add(16);
        System.out.println(b.toString());
    }
}


