package com.bmcl.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    private List<Integer> list1;
    private List<Integer> expected1;

    @Before
    public void helper() {
        list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        list1.add(5);

        expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(2);
        expected1.add(4);
        expected1.add(5);
    }

    @Test
    public void deduplicate() {
        GenericListDeduplicator deduplicator1 = new ListDeduplicator(list1);
        List<Integer> distinct1 = deduplicator1.deduplicate(list1);

        assertEquals(expected1, distinct1);
    }
}
