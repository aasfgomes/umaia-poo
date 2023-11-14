package com.bmcl.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSorter implements GenericListSorter {
    private final List<Integer> list;

    public ListSorter(List<Integer> list) {
        this.list = list;
    }

    /**
     * Sorts the list in ascending order.
     * @return A sorted version of the list.
     */
    public List<Integer> sort() {
        List<Integer> sorted = new ArrayList<>(list);

        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i) > sorted.get(j)) {
                    Collections.swap(sorted, i, j);
                }
            }
        }

        return sorted;
    }
}
