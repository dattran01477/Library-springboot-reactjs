package com.library.bussiness.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {

	public static LocalDateTime getTomorrow() {
		LocalDateTime today = LocalDateTime.now();
		return today.plus(1, ChronoUnit.DAYS);
	}

	public static LocalDateTime createDate(int hour, int minute, LocalDateTime localDT) {
		LocalDateTime resDateTime = LocalDateTime.of(localDT.getYear(), localDT.getMonth(), localDT.getDayOfMonth(),
				hour, minute);
		return resDateTime;
	}

	public static LocalDateTime getTomorrowOfDate(LocalDateTime localDT) {
		if (localDT != null) {
			return localDT.plus(1, ChronoUnit.DAYS);
		}
		return null;
	}

	public static Boolean checkDateExistInRangeDate(LocalDateTime localDT, LocalDateTime fromDate,
			LocalDateTime toDate) {
		if (localDT.isAfter(fromDate) && localDT.isBefore(toDate)) {
			return true;
		}
		return false;
	}

	public static LocalDateTime roundLocalDateTime(int onMinute, int belowMinute, LocalDateTime localDT) {
		int minute = localDT.getMinute();
		if (minute >= belowMinute && minute < onMinute + ((onMinute + belowMinute) / 2)) {
			return DateTimeUtils.createDate(localDT.getHour(), onMinute, localDT);
		} else {
			return DateTimeUtils.createDate(localDT.getHour(), belowMinute, localDT);
		}
	}
}
