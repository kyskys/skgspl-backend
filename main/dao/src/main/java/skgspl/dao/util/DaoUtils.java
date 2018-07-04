package skgspl.dao.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import skgspl.dto.report.TimetableSubreportItem;
import skgspl.entity.Lesson;

public class DaoUtils {
	public static List<TimetableSubreportItem> getEmptyTimetable() {
		return IntStream.range(0, 20).mapToObj(i -> new TimetableSubreportItem()).collect(Collectors.toList());
	}

	public static void fillTimetable(List<TimetableSubreportItem> source, List<Lesson> lessons) {
		lessons.forEach(lesson -> {
			source.set(lesson.getDate().getDayOfWeek().getValue() * 4 + lesson.getTime().getId().intValue(),
					new TimetableSubreportItem(lesson));
		});
	}
}
