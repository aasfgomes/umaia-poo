package com.bmcl.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListDeduplicator implements GenericListDeduplicator {
    private final List<Integer> list;

    public ListDeduplicator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> deduplicate(List<Integer> listToDeduplicate) {
        List<Integer> deduplicatedList = new ArrayList<>();

        for (Integer number : listToDeduplicate) {
            if (!deduplicatedList.contains(number)) {
                deduplicatedList.add(number);
            }
        }

        return deduplicatedList;
    }
}
