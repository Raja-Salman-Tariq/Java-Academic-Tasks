package com.company;

import java.util.ArrayList;

//---------------------------------------
//--------- EMPTY SET IMPLEMENTATION
//---------------------------------------
class EmptySet implements IntSet {

    //---------------------------------------
    //-------- EMPTY SET CONSTRUCTOR
    //---------------------------------------
    EmptySet() {
    }

    //---------------------------------------
    //-------- ADD IMPLEMENTATION
    //---------------------------------------
    @Override
    public IntSet add(int x) {
        return new SingletonSet(x);
    }

    //---------------------------------------
    //-------- CONTAINS IMPLEMENTATION
    //---------------------------------------
    @Override
    public boolean contains(int x) {
        return false;
    }

    //---------------------------------------
    //-------- UNION IMPLEMENTATION
    //---------------------------------------
    @Override
    public IntSet union(IntSet other) {
        return other;
    }

    //---------------------------------------
    //-------- Helper Function
    //---------------------------------------

    // Returns type of class
    //      e implies empty set
    //      s implies singleton set
    //      t implies tree set
    public String type() {
        return "e";
    }

    //---------------------------------------
    //-------- Helper Function
    //---------------------------------------

    // Retrieves element in set as an Array List.
    // Since empty set is empty, null is returned.
    @Override
    public ArrayList<Integer> getElements() {
        return null;
    }

    //---------------------------------------
    //-------- TOSTRING IMPLEMENTATION
    //---------------------------------------
    @Override
    public String toString() {
        return "{ }";
    }
}
