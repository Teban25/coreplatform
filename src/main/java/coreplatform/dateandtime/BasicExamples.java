package coreplatform.dateandtime;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.MonthDay;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Examples of use with date times library
 * 
 * @author Esteban
 *
 */
public class BasicExamples {

	public static void main(String[] args) {

		// int monthLength = MonthDay.now().getMonth().maxLength(); -> don't let your
		// code depend on the current date-time
		Clock testClock = Clock.fixed(Instant.EPOCH, ZoneOffset.UTC);
		//usingInstant(testClock);
		usingDuration(testClock);
	}

	/*
	 * The Instant class is immutable. So always returns a new instance in each
	 * operation
	 */
	public static void usingInstant(Clock testClock) {
		System.out.println("Using Instant API.....");
		Instant instant1 = Instant.now(testClock);
		Instant instant2 = Instant.now();
		Instant instant3 = Instant.now(Clock.systemUTC());
		Instant instant4 = Instant.ofEpochMilli(System.currentTimeMillis());

		long now = System.currentTimeMillis();

		Instant instant5 = Instant.ofEpochSecond(now / 1000);
		Instant instant6 = Instant.ofEpochSecond(now / 1000, 655000000);
		Instant instant7 = Instant.parse("2021-12-09T10:15:30.00Z");

		System.out.println("Instant 1 " + instant1);
		System.out.println("Instant 2 " + instant2);
		System.out.println("Instant 3 " + instant3);
		System.out.println("Instant 4 " + instant4);
		System.out.println("Instant 5 " + instant5);
		System.out.println("Instant 6 " + instant6);
		System.out.println("Instant 7 " + instant7);

		System.out.println("EpochSecond: " + instant2.getEpochSecond());
		System.out.println("Nano: " + instant2.getNano());

		System.out.println("EpochSecond using get: " + instant2.getLong(ChronoField.INSTANT_SECONDS));
		System.out.println("Nano using get: " + instant2.get(ChronoField.NANO_OF_SECOND));

		Instant instant8 = instant2.minusSeconds(15);
		System.out.println("Instant 8 is instant2 minus 15 seconds: " + instant8);
		System.out.println("Instant 8 plus 30 secs: " + instant8.plusSeconds(15));
		System.out.println("Instant 8 plus a specific amount (2 mins): " + instant8.plus(2, ChronoUnit.MINUTES));
		System.out.println("Instant 8 minus a specific amount (2 days): " + instant8.minus(2, ChronoUnit.DAYS));

		System.out.println("Comparing instants....");
		System.out.println("Instant8 before Instant2: " + instant8.isBefore(instant2));
		System.out.println("Instant2 after Instant3: " + instant8.isAfter(instant2));
		System.out.println("Instant8 compareTo Instant2: " + instant8.compareTo(instant2));
		System.out.println("Instant2 compareTo Instant3: " + instant3.compareTo(instant2));
		System.out.println("Instant7 compareTo Instant2: " + instant7.compareTo(instant2));
		System.out.println("Finish using Instant API.....");
	}

	/*
	 * Duration uses time based values
	 */
	public static void usingDuration(Clock testClock) {
		int monthLength = MonthDay.now(testClock).getMonth().maxLength();
		Duration duration1 = Duration.of(2, ChronoUnit.DAYS);
		Duration duration2 = Duration.ofSeconds(1, 1);
		Duration duration3 = duration2.withSeconds(2);
		Duration duration4 = duration2.plusSeconds(2);
		Duration duration5 = duration4.withSeconds(2);
		Instant instant1 = Instant.parse("2021-11-10T10:15:30.00Z");
		Instant instant2 = Instant.parse("2021-11-08T10:13:20.00Z");
		
		Duration duration6 = Duration.between(instant2, instant1);
		Duration duration7 = duration6.plus(1, ChronoUnit.SECONDS);
		Duration duration8 = Duration.of(500, ChronoUnit.DAYS);
		Duration duration9 = Duration.ofDays(500);
		System.out.println(duration1);
		System.out.println(duration2);
		System.out.println(duration3);
		System.out.println(duration4);
		System.out.println(duration5);
		System.out.println(duration6);
		System.out.println(duration7);
		System.out.println(duration8);
		System.out.println(duration9);
		System.out.println(duration7.getSeconds());
		System.out.println(monthLength);
	}

	/*
	 * Period uses date based values
	 */
	public static void usingPeriod(Clock testClock) {
		
	}

	public static void usingLocalDate(Clock testClock) {

	}

	public static void usingZoneDateTime(Clock testClock) {

	}
}
