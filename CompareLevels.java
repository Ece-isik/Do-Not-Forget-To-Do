package com.company;

import java.util.Comparator;

public class CompareLevels implements Comparator<List> {

    @Override
    public int compare(List o1, List o2) { //to sort the arrayList by levels
        return o1.getValueOfLevel() - o2.getValueOfLevel();
    }
}
