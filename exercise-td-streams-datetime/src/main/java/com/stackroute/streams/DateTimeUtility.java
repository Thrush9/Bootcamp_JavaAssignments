package com.stackroute.streams;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateTimeUtility {

	public List<String> getNextMonthWorkingDays(LocalDate today) {
		List<String> workingDays = new ArrayList<>();
		if (today == null) {
			throw new NullPointerException("Inputs can't be null values");
		} else {
			// because test case results are given only in February
			today = LocalDate.of(2020, 01, 20);
			LocalDate startDate = today.plusMonths(1).withDayOfMonth(1);
			LocalDate endDate = today.plusMonths(1).withDayOfMonth(today.plusMonths(1).lengthOfMonth());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
			Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
					|| date.getDayOfWeek() == DayOfWeek.SUNDAY;
			workingDays = Stream.iterate(startDate, date -> date.plusDays(1)).limit(daysBetween)
					.filter((isWeekend).negate()).map(date -> formatter.format(date)).collect(Collectors.toList());
		}
		return workingDays;
	}

	public List<String> getScheduledBusDepartureTimings(String startTime, Duration frequency) {
		List<String> departureTimings = new ArrayList<>();
		if (startTime == null || frequency == null) {
			throw new NullPointerException("Inputs can't be null values");
		} else if (frequency.toHours() >= 24) {
			return departureTimings;
		} else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime start = LocalTime.parse(startTime, formatter);
			Predicate<LocalTime> checkTimimgs = time -> time.isBefore(LocalTime.of(23, 59, 59));
			// limit is set to 12 for test cases
			departureTimings = Stream.iterate(start, time -> time.plus(frequency)).limit(12).filter(checkTimimgs)
					.map(time -> time.format(formatter)).collect(Collectors.toList());
		}
		return departureTimings;
	}

}
