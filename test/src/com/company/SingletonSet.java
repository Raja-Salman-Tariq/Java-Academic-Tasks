package com.company;

import java.util.ArrayList;

//---------------------------------------
//--------- SINGLETON SET IMPLEMENTATION
//---------------------------------------

class SingletonSet implements IntSet {
    int element;

    //---------------------------------------
    //-------- SINGLETON CONSTRUCTOR
    //---------------------------------------
    SingletonSet(int x) {
        element = x;
    }

    //---------------------------------------
    //-------- TOSTRING IMPLEMENTATION
    //---------------------------------------
    @Override
    public String toString() {
        return "{ " + element + " }";
    }

    //---------------------------------------
    //-------- CONTAINS IMPLEMENTATION
    //---------------------------------------
    @Override
    public boolean contains(int x) {
        return element == x;
    }

    //---------------------------------------
    //-------- ADD IMPLEMENTATION
    //---------------------------------------
    @Override
    public IntSet add(int x) {
        if (contains(x))
            return this;

        ArrayList<Integer> elements = new ArrayList<Integer>();
        elements.add(element);
        elements.add(x);
        return new TreeSet(elements);
    }

    //---------------------------------------
    //-------- UNION IMPLEMENTATION
    //---------------------------------------
    @Override
    public IntSet union(IntSet other) {
        ArrayList<Integer> ele = other.getElements();

        IntSet i = new EmptySet();

        for (int x : ele) {
            i.add(x);
        }
        ;
        return i;
    }

    //---------------------------------------
    //-------- Helper Function
    //---------------------------------------

    // Returns type of class
    //      e implies empty set
    //      s implies singleton set
    //      t implies tree set
    @Override
    public String type() {
        return "s";
    }

    //---------------------------------------
    //-------- Helper Function
    //---------------------------------------

    // Retrieves element in set as an Array List
    @Override
    public ArrayList<Integer> getElements() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(element);
        return a;
    }

}
