package com.library.bussiness;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.bussiness.utils.DateTimeUtils;

@RunWith(SpringRunner.class)

public class BussinessApplicationTests {

	@Test
	public void contextLoads() {
		LocalDateTime tomorrow = DateTimeUtils.getTomorrow();
		LocalDateTime tomorrowOftomorrow = DateTimeUtils.getTomorrowOfDate(tomorrow);
		LocalDateTime fromDate = DateTimeUtils.createDate(8, 30, tomorrowOftomorrow);
		LocalDateTime toDate = DateTimeUtils.createDate(16, 30, tomorrowOftomorrow);
		LocalDateTime currentDate = DateTimeUtils.createDate(17, 35, tomorrowOftomorrow);
		Boolean isInRange = DateTimeUtils.checkDateExistInRangeDate(currentDate, fromDate, toDate);
		LocalDateTime rounđate=DateTimeUtils.roundLocalDateTime(0, 30, currentDate);
		System.out.println(rounđate);
	}

}
