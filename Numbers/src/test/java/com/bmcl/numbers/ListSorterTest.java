package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        ListSorter sorter = new ListSorter(list);

        List<Integer> sorted = sorter.sort();

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void bug_sort_8276() {
        ListSorter sorter = new ListSorter(Arrays.asList(1, 2, 4, 2));
        List<Integer> sorted = sorter.sort();
        Assertions.assertEquals(Arrays.asList(1, 2, 2, 4), sorted);
    }
}
