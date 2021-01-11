package com.company;

import java.util.ArrayList;

//---------------------------------------
//--------- IntSet IMPLEMENTATION
//---------------------------------------

interface IntSet {// Our Interface Class

    IntSet add(int x);
    IntSet union(IntSet other);
    boolean contains(int x);

    @Override
    String toString();
    String type();
    ArrayList<Integer> getElements();

}
