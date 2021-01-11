package com.company;

import java.util.ArrayList;

//---------------------------------------
//----------- TREE SET IMPLEMENTATION
//---------------------------------------


class TreeSet implements IntSet {
    IntSet leftElements;
    IntSet rightElements;
    ArrayList<Integer> elements;


    //---------------------------------------
    //-------- TREESET CONSTRUCTOR
    //---------------------------------------
    TreeSet(ArrayList<Integer> _elements) {
        elements = _elements;
        leftElements = new EmptySet();
        rightElements = new EmptySet();

        for (int e : elements) {
            if (e % 2 == 0)
                leftElements = leftElements.add(e / 2);
            else rightElements = rightElements.add(e / 2);
        }
    }


    //---------------------------------------
    //-------- TOSTRING IMPLEMENTATION
    //---------------------------------------
    @Override
    public String toString() {
        ArrayList<Integer> ele = getElements();

        if (ele.size() == 0)
            return "{ }";

        String s = "{ " + (ele.get(0)).toString();

        for (int i = 1; i < ele.size(); i++) {
            s += (", " + ele.get(i).toString());
        }

        return (s + "}");
    }

    //---------------------------------------
    //-------- ADD IMPLEMENTATION
    //---------------------------------------
    @Override
    public IntSet add(int x) {

        IntSet i = new EmptySet();

        ArrayList<Integer> ele = getElements();

        for (int e : ele)
            i = i.add(e);

        adder(i, x);

        return i;
    }

    //---------------------------------------
    //-------- CONTAINS IMPLEMENTATION
    //---------------------------------------
    @Override
    public boolean contains(int x) {
        IntSet i;
        boolean found = false;

        while (!found) {
            if (x % 2 == 1)
                i = rightElements;
            else i = leftElements;

            x = x / 2;

            if (i.type() == "e")
                return false;

            if (i.type() == "s") {
                if (i.getElements().get(0) == x) {
                    found = true;
                    return true;
                }
            }
        }
        return true;
    }

    //---------------------------------------
    //-------- UNION IMPLEMENTATION
    //---------------------------------------
    @Override
    public IntSet union(IntSet other) {
        IntSet i = this;
        ArrayList<Integer> ele = other.getElements();

        for (int x : ele) {
            i.add(x);
        }

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
        return "t";
    }

    //---------------------------------------
    //-------- Helper Function
    //---------------------------------------

    // Traverses the tree set to obtain all
    // contained integers
    private void explore(TreeSet i, ArrayList<Integer> a, String path) { // path keeps track of the path followed
        if (i.leftElements.type() == "t")                                // to reach an integer. The path is used to
            explore((TreeSet) i.leftElements, a, path + "L");         // compute the actual integer value since it
        else if (i.leftElements.type() == "s") {                         // has been halved many times when being stored.
            String nPath = path + "L";
            int val = i.leftElements.getElements().get(0);
            for (int x = nPath.length() - 1; x >= 0; x--) {
                if (nPath.charAt(x) == 'L') {
                    val *= 2;
                } else {
                    val *= 2;
                    val += 1;
                }
            }
            a.add(val);
        }
        if (i.rightElements.type() == "t")
            explore((TreeSet) i.rightElements, a, path + "R");
        else if (i.rightElements.type() == "s") {
            String nPath = path + "R";
            int val = i.leftElements.getElements().get(0);
            ;
            for (int x = nPath.length() - 1; x >= 0; x--) {
                if (nPath.charAt(x) == 'L') {
                    val *= 2;
                } else {
                    val *= 2;
                    val += 1;
                }
            }
            a.add(val);
        }
    }

    //---------------------------------------
    //-------- Helper Function
    //---------------------------------------

    // Retrieves all elements in set in conjunction with explore()
    @Override
    public ArrayList<Integer> getElements() {
        ArrayList<Integer> ele = new ArrayList<Integer>();

        explore(this, ele, "");

        return ele;
    }

    //---------------------------------------
    //-------- Helper Function
    //---------------------------------------

    // Attempts to add integer at appropriate location.
    private IntSet adder(IntSet is, int i) {
        if (is.type() == "e") {
            return is.add(i);
        }

        if (is.type() == "s")
            if (!is.contains(i)) {
                return is.add(i);
            }

        if (i % 2 == 0) {
            IntSet t;
            if (is.type() == "t")
                t = adder(((TreeSet) is).leftElements, i / 2);
            else {
                return adder(is, i / 2);
            }
            ((TreeSet) is).leftElements = t;
            return is;
        } else {
            IntSet t;
            if (is.type() == "t")
                t = adder(((TreeSet) is).rightElements, i / 2);
            else {
                return adder(is, 1 / 2);
            }
            ((TreeSet) is).rightElements = t;
            return is;
        }
    }

}

