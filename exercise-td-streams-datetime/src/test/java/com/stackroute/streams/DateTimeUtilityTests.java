package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTimeUtilityTests {

    public static final String MESSAGE_ONE = "List of working days for next month not returned properly";
    public static final String MESSAGE_TWO = "List of departure timings for the given start time and frequency is not returned properly";
    public static final String MESSAGE_THREE = "Invalid Date throws exception";
    public static final String MESSAGE_FOUR = "Null values throws exception";
    public static final String MESSAGE_FIVE = "Invalid Time throws exception";
    public static final String MESSAGE_SIX = "Invalid duration should return empty list";
    private String startTime = "08:00:00";

    private DateTimeUtility dateTimeUtility;

    @BeforeEach
    public void setUp() {
        dateTimeUtility = new DateTimeUtility();
    }

    @AfterEach
    public void tearDown() {
        dateTimeUtility = null;
    }

    @Test
    public void givenCurrentMonthReturnNextMonthWorkingDays() {
        LocalDate today = LocalDate.now();
        List<String> actual = dateTimeUtility.getNextMonthWorkingDays(today);
        assertThat(MESSAGE_ONE, actual, hasSize(20));
        assertThat(MESSAGE_ONE, actual, contains("2020-02-03", "2020-02-04", "2020-02-05", "2020-02-06", "2020-02-07", "2020-02-10", "2020-02-11",
                "2020-02-12", "2020-02-13", "2020-02-14", "2020-02-17", "2020-02-18", "2020-02-19", "2020-02-20", "2020-02-21", "2020-02-24", "2020-02-25", "2020-02-26", "2020-02-27", "2020-02-28"));
    }


    @Test
    public void givenInvalidMonthThrowsException() {
        assertThrows(DateTimeException.class, () -> {
            LocalDate today = LocalDate.of(2020, 13, 01);
            dateTimeUtility.getNextMonthWorkingDays(today);
        }, MESSAGE_THREE);
    }

    @Test
    public void givenInvalidDateThrowsException() {
        assertThrows(DateTimeException.class, () -> {
            LocalDate today = LocalDate.of(2020, 13, 41);
            dateTimeUtility.getNextMonthWorkingDays(today);
        }, MESSAGE_THREE);
    }

    @Test
    public void givenNullDateThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            LocalDate today = null;
            dateTimeUtility.getNextMonthWorkingDays(today);
        }, MESSAGE_FOUR);
    }

    @Test
    public void givenStartTimeAndFrequencyDurationReturnDepartureTimingStringList() {
        Duration frequency = Duration.ZERO.plus(1, HOURS).plusMinutes(25);
        List<String> actual = dateTimeUtility.getScheduledBusDepartureTimings(startTime, frequency);
        assertThat(MESSAGE_TWO, actual, hasSize(12));
        assertThat(MESSAGE_TWO, actual, contains("08:00:00", "09:25:00", "10:50:00", "12:15:00", "13:40:00", "15:05:00", "16:30:00", "17:55:00", "19:20:00", "20:45:00", "22:10:00", "23:35:00"));
    }

    @Test
    public void givenInvalidTimeThrowsException() {
        assertThrows(DateTimeException.class, () -> {
            startTime = "8:00:00";
            Duration frequency = Duration.ZERO.plus(1, HOURS).plusMinutes(25);
            dateTimeUtility.getScheduledBusDepartureTimings(startTime, frequency);
        }, MESSAGE_FIVE);
    }

    @Test
    public void givenInvalidDurationReturnEmptyList() {
        Duration frequency = Duration.ZERO.plus(1, DAYS);
        List<String> actual = dateTimeUtility.getScheduledBusDepartureTimings(startTime, frequency);
        assertThat(MESSAGE_SIX, actual, is(empty()));
    }

    @Test
    public void givenNullValuesThrowsException() {
        Duration frequency = null;
        startTime = null;
        assertThrows(NullPointerException.class, () ->
                        dateTimeUtility.getScheduledBusDepartureTimings(startTime, frequency)
                , MESSAGE_FOUR);
    }
}
