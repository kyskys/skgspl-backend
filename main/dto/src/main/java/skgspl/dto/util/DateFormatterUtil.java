package skgspl.dto.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {

	public enum FormatEnum {
		DATE_FORMATTER("dd/MM/yyyy"), TIME_FORMATTER("HH:mm"), DAY_TO_PRINT_FORMATTER("dd.MM");

		private DateTimeFormatter formatter;

		FormatEnum(String pattern) {
			this.formatter = DateTimeFormatter.ofPattern(pattern);
		}

		DateTimeFormatter getFormatter() {
			return formatter;
		}
	}

	public static String getDateAsString(LocalDateTime date, FormatEnum format) {
		return date.format(format.getFormatter());
	}

	public static LocalDateTime getDateFromString(String date, FormatEnum format) {
		return date != null ? LocalDateTime.of(LocalDate.parse(date, format.getFormatter()), LocalTime.of(3, 0)) : null;
	}

	public static String getTimeAsString(LocalTime time, FormatEnum format) {
		return time.format(format.getFormatter());
	}

	public static LocalTime getTimeFromString(String time, FormatEnum format) {
		return time != null ? LocalTime.parse(time, format.getFormatter()) : null;
	}
}
