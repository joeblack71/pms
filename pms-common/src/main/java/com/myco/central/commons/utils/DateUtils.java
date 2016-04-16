package com.myco.central.commons.utils;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	public enum DateFormats {
		DEFAULT_DATE_FORMAT("yyyy-MM-dd"), LOCAL_DATE_FORMAT("dd/MM/yyyy"), TWO_DIGITS_DATE_FORMAT(
				"dd/MM/yy"), DAY_MONTH_DATE_FORMAT("dd/MM");

		private String format;

		DateFormats(String format) {
			this.format = format;
		}

		String format() {
			return format;
		}
	}

	protected static final long WEEK_DAYS = ChronoUnit.WEEKS.getDuration().toDays();
	protected static final long MONTH_DAYS = ChronoUnit.MONTHS.getDuration().toDays();
	protected static final long QUARTER_DAYS = IsoFields.QUARTER_YEARS.getDuration().toDays();
	protected static final long YEAR_DAYS = ChronoUnit.YEARS.getDuration().toDays();

	private DateUtils() {
	}

	/**
	 * @param startDate
	 * @param period
	 *            a period of time eg. "1 month 3 weeks 14 days"
	 * @return a new LocalDate instance resulting of to add a period of time to
	 *         a date
	 */
	public static LocalDate addUnitsToDate(LocalDate startDate, Period period) {
		System.out.println(period.getDays());
		System.out.println(period.get(ChronoUnit.DAYS));
		// startDate.plusDays(period.get(ChronoUnit.DAYS));
		return startDate.plusDays(period.getDays());
	}

	protected static LocalDate addDaysToDate(LocalDate startDate, TemporalUnit temporalUnit) {
		if (!temporalUnit.isDateBased()) {
			LOGGER.error(String.format("This %s is not based on a unit date", temporalUnit));
			throw new InvalidParameterException();
		}

		return startDate.plusDays(temporalUnit.getDuration().toDays());
	}

	public static List<LocalDate> getAllDatesInDateRange(LocalDate startDate, LocalDate endDate) {
		long amountOfDays = ChronoUnit.DAYS.between(startDate, endDate);
		List<LocalDate> dates = new ArrayList<>(Long.valueOf(amountOfDays).intValue());

		LocalDate nextDate = LocalDate.from(startDate);
		while (nextDate.isBefore(endDate)) {
			dates.add(nextDate);
			nextDate = nextDate.plusDays(1);
		}

		dates.forEach(d -> System.out.println(d));

		return dates;
	}

	public static List<LocalDate> getAllDatesInPeriod(LocalDate startDate, Period period) {
		LocalDate endDate = startDate.plusDays(period.getDays());

		return getAllDatesInDateRange(startDate, endDate);
	}

	public static String formatDate(LocalDate date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DateFormats.TWO_DIGITS_DATE_FORMAT.format());
		return date != null ? date.format(format) : LocalDate.now().format(format);
	}

	public static LocalDate parseDate(String stringDate) {
		return parseStringToLocalDate(stringDate, DateFormats.LOCAL_DATE_FORMAT.format());
	}

	protected static LocalDate parseStringToLocalDate(String stringDate, String pattern) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(stringDate, format);
	}

	public static void main(String[] args) {
		// addDaysToDate(LocalDate.now(), ChronoUnit.WEEKS);
		// addDaysToDate(LocalDate.now(), ChronoUnit.MONTHS);
		// addDaysToDate(LocalDate.now(), IsoFields.QUARTER_YEARS);
		LocalDate endDate = addUnitsToDate(LocalDate.now(), Period.ofWeeks(2));
		System.out.printf("%s", endDate);
		/*
		 * try { LocalDate startDate = parseStringToLocalDate("30/0/2016");
		 * addDaysToDate(startDate, ChronoUnit.WEEKS.getDuration().toDays()); }
		 * catch (DateTimeParseException ex) { LOGGER.info(
		 * "Error in date parsing", ex); }
		 */
		// getAllDatesInDateRange(LocalDate.now(),
		// LocalDate.now().plusDays(40));
		// getAllDatesInPeriod(LocalDate.now(), Period.ofDays(40));
	}
}