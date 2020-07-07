package com.iipay.sample;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.SortedSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DateSorterImplTest {

    @Test
    void sortDates() {
        DateSorter dateSorter = new DateSorterImpl();

        HashSet<LocalDate> dates = new HashSet<>();
        dates.add(LocalDate.of(2019, 7, 1));
        dates.add(LocalDate.of(2019, 1, 2));
        dates.add(LocalDate.of(2019, 1, 1));
        dates.add(LocalDate.of(2019, 5, 3));

        SortedSet<LocalDate> result = dateSorter.sortDates(dates);

        assertThat(result).containsExactly(LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 1, 2),
                LocalDate.of(2019, 7, 1),
                LocalDate.of(2019, 5, 3));
    }
}