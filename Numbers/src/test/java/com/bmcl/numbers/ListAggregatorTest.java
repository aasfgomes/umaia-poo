package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    List<Integer> list;

    @BeforeEach
    public void setup() {
        list = Arrays.asList(1, 2, 4, 2, 5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);
        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);
        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));
        int distinct = aggregator.distinct(deduplicator);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void maxbug7263() {
        List<Integer> list2 = Arrays.asList(-1, -4, -5);

        ListAggregator aggregator = new ListAggregator(list2);
        int max = aggregator.max();

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void max_bug_8726() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        ListAggregator aggregator = new ListAggregator(list);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        int distinct = aggregator.distinct(deduplicator);

        Assertions.assertEquals(3, distinct);
    }
}
