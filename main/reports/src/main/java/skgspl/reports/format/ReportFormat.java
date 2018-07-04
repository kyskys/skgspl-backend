package skgspl.reports.format;

import java.util.Arrays;
import java.util.EnumSet;

public enum ReportFormat {

	RTF(""), DOCX(""), HTML("text/html"), XLS(""), XLSX(""), CSV("text/csv"), XML(""), JPEG(""),
	/** Формат отчета - изображения страниц, упакованные в архив */
	ZIP_OF_JPEG("", "zip", "JPEG"), PDF("");

	private final String mimeType;
	private String fileExtension;
	private String displayValue;

	ReportFormat(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * @param mimeType
	 *            MIME-тип, соответствующий формату отчета
	 * @param fileExtension
	 *            расширение файла, соответствующее формату отчета
	 * @param displayValue
	 *            отображаемое наименование формата отчета
	 */
	ReportFormat(String mimeType, String fileExtension, String displayValue) {
		this.mimeType = mimeType;
		this.fileExtension = fileExtension;
		this.displayValue = displayValue;
	}

	/**
	 * Возвращает MIME-тип, соответствующий формату отчета
	 *
	 * @return MIME-тип
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @return расширение файла, соответствующее формату отчета
	 */
	public String getFileExtension() {
		return fileExtension == null ? name().toLowerCase() : fileExtension;
	}

	/**
	 * @return отображаемое наименование формата отчета
	 */
	public String getDisplayValue() {
		return displayValue == null ? name() : displayValue;
	}

	/**
	 * @param exclusions
	 *            исключения
	 *
	 * @return возвращает все форматы за исключением указанных
	 */
	public static EnumSet<ReportFormat> values(ReportFormat... exclusions) {
		EnumSet<ReportFormat> values = EnumSet.allOf(ReportFormat.class);
		values.removeAll(Arrays.asList(exclusions));
		return values;
	}
}