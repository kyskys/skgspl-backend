package test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import item.TimetableReportItem;
import item.TimetableSubreportItem;
import net.sf.jasperreports.engine.JRException;
import skgspl.reports.builder.JasperReportBuilder;
import skgspl.reports.format.ReportFormat;

public class Main {
	public static void main(String... args) {
//		 try {
//		 Files.createFile(Paths.get("D://report.pdf"));
//		 } catch (IOException e1) {
//		 // TODO Auto-generated catch block
//		 e1.printStackTrace();
//		 }
		List<TimetableReportItem> rep = new ArrayList<TimetableReportItem>();
		TimetableReportItem item = new TimetableReportItem();
		item.setFirstGroupName("группа 1");
		item.setSecondGroupName("группа 2");
		List<TimetableSubreportItem> firstGroupItem = new ArrayList<TimetableSubreportItem>();
		TimetableSubreportItem firstLesson = new TimetableSubreportItem();
		firstLesson.setSubjectName("Предмет 1");
		firstLesson.setLecturerFIO("препод 1\nпрепод 2");
		firstLesson.setRoomNumber("каб. 1\nкаб. 2");
		firstGroupItem.add(firstLesson);
		firstGroupItem.add(new TimetableSubreportItem());
		TimetableSubreportItem secondLesson = new TimetableSubreportItem();
		secondLesson.setSubjectName("Предмет 2");
		secondLesson.setLecturerFIO("препод 3\nпрепод 4\nпрепод 5");
		secondLesson.setRoomNumber("каб. 3\nкаб. 4\nкаб. 5");
		firstGroupItem.add(secondLesson);
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		TimetableSubreportItem thirdLesson = new TimetableSubreportItem();
		thirdLesson.setSubjectName("Предмет 3");
		thirdLesson.setLecturerFIO("препод 6");
		thirdLesson.setRoomNumber("каб. 6");
		firstGroupItem.add(thirdLesson);
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		firstGroupItem.add(new TimetableSubreportItem());
		item.setFirstGroupData(firstGroupItem);
		item.setSecondGroupData(firstGroupItem);
		rep.add(item);
		JasperReportBuilder builder = new JasperReportBuilder();
		try (FileOutputStream fos = new FileOutputStream("D://report.pdf")) {
			// Writer writer = new ByteWriter(new FileWriter("report.pdf"));
			Map<String, Object> map = new HashMap<>();
			map.put("firstDay","07.01");
			map.put("lastDay", "10.01");
			map.put("year", "2018");
			map.put("profPresident","А.А. Предко");
			map.put("director", "В.Н. Салей");
			byte[] bytes = builder.buildReportWithObjects(JasperReportBuilder.ReportTemplate.REPORT_TEMPLATE,
					ReportFormat.PDF, map, rep);
			fos.write(bytes);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
