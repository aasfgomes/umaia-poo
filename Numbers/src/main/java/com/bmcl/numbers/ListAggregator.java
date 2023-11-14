package com.bmcl.numbers;

import java.util.List;

public class ListAggregator {
    private final List<Integer> list;

    public ListAggregator(List<Integer> list) {
        this.list = list;
    }

    public Integer sum() {
        int sum = 0;

        for (Integer number : list)
            sum += number;

        return sum;
    }

    public Integer max() {
        int max = Integer.MIN_VALUE;

        for (Integer number : list)
            if (number > max)
                max = number;

        return max;
    }

    public Integer min() {
        int min = Integer.MAX_VALUE;

        for (Integer number : list)
            if (number < min)
                min = number;

        return min;
    }

    public int distinct(GenericListDeduplicator deduplicator) {
        List<Integer> distinct = deduplicator.deduplicate(list);

        return distinct.size();
    }
}
