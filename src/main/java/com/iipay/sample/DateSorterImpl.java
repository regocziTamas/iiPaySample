package com.iipay.sample;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DateSorterImpl implements DateSorter {

    public static final String TARGET_LETTER_R = "R";

    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {

        TreeSet<LocalDate> sortedDates = new TreeSet<>(new CustomDateComparator());
        sortedDates.addAll(unsortedDates);

        return sortedDates;
    }

    private static class CustomDateComparator implements Comparator<LocalDate> {

        @Override
        public int compare(LocalDate date1, LocalDate date2) {

            if (bothDateMonthsContainTargetLetter(date1, date2))
                return date1.compareTo(date2);
            else if (neitherDateMonthsContainTargetLetter(date1, date2))
                return reverseResult(date1.compareTo(date2));
            else
                return handleOnlyOneDateMonthContainsTargetLetter(date1);
        }

        private boolean bothDateMonthsContainTargetLetter(LocalDate date1, LocalDate date2) {
            return dateMonthContainsTargetLetter(date1) && dateMonthContainsTargetLetter(date2);
        }

        private boolean neitherDateMonthsContainTargetLetter(LocalDate date1, LocalDate date2) {
            return !dateMonthContainsTargetLetter(date1) && !dateMonthContainsTargetLetter(date2);
        }

        private int reverseResult(int result) {
            return -result;
        }

        private int handleOnlyOneDateMonthContainsTargetLetter(LocalDate date1) {
            if (dateMonthContainsTargetLetter(date1))
                return -1;
            else
                return 1;
        }

        private boolean dateMonthContainsTargetLetter(LocalDate date) {
            return date.getMonth().toString().contains(TARGET_LETTER_R);
        }
    }
}
