package skgspl.reports.builder;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleCsvReportConfiguration;
import net.sf.jasperreports.export.SimpleDocxExporterConfiguration;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterConfiguration;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleReportExportConfiguration;
import net.sf.jasperreports.export.SimpleRtfExporterConfiguration;
import net.sf.jasperreports.export.SimpleRtfReportConfiguration;
import net.sf.jasperreports.export.SimpleTextExporterConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.export.SimpleXmlExporterOutput;
import skgspl.reports.format.ReportFormat;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class JasperReportBuilder {

   // private static final Logger logger = LoggerFactory.getLogger(JasperReportBuilder.class);

    private static final String REPORT_TEMPLATES_BIN_DIRECTORY = "templates/";
    private static final String REPORT_TEMPLATE_EXTENSION = ".jasper";

    /**
     * Шаблоны отчетов JR
     */
    public enum ReportTemplate {

        /**
         * Тестовый шаблон
         */
        TEST("test.jasper"),
    	REPORT_TEMPLATE("ReportTemplate.jasper");

        private final String templateFileName;

        /**
         * @param templateFileName наименование файла шаблона отчета
         */
        ReportTemplate(String templateFileName) {
            if (!templateFileName.endsWith(REPORT_TEMPLATE_EXTENSION)) {
                throw new IllegalArgumentException(
                        "Наименование скомпилированного файла шаблона отчета JasperReports должно иметь расширение "
                                + REPORT_TEMPLATE_EXTENSION);
            }
            this.templateFileName = templateFileName;
        }

        /**
         * Возвращает Наименование файла шаблона отчета (без расширения)
         *
         * @return Наименование файла шаблона отчета
         */
        public String getTemplateFileName() {
            return templateFileName;
        }

    }

    /**
     * Создает и возвращает экземпляр отчета - документ в формате DOCX в виде массива байтов.
     *
     * @param reportTemplate шаблон отчета
     * @return файл отчета в виде массива байтов
     * @throws JRException
     */
    public byte[] buildReport(ReportTemplate reportTemplate) throws JRException {
        return buildReport(reportTemplate, ReportFormat.DOCX);
    }

    /**
     * Создает и возвращает экземпляр отчета - документ в формате DOCX в виде массива байтов.
     *
     * @param reportTemplate шаблон отчета
     * @return файл отчета в виде массива байтов
     * @throws JRException
     */
    public byte[] buildReport(ReportTemplate reportTemplate, Connection connection) throws JRException {
        return buildReport(reportTemplate, ReportFormat.DOCX, connection);
    }

    /**
     * Создает и возвращает файл отчета в виде массива байтов по наименованию файла шаблона.
     *
     * @param reportTemplate шаблон отчета
     * @param reportFormat   формат отчета
     * @return файл отчета в виде массива байтов
     * @throws JRException
     */
    public byte[] buildReport(ReportTemplate reportTemplate, ReportFormat reportFormat) throws JRException {
        return buildReport(reportTemplate, reportFormat, (Map<String, Object>) null);
    }

    /**
     * Создает и возвращает файл отчета в виде массива байтов по наименованию файла шаблона.
     *
     * @param reportTemplate шаблон отчета
     * @param reportFormat   формат отчета
     * @return файл отчета в виде массива байтов
     * @throws JRException
     */
    public byte[] buildReport(ReportTemplate reportTemplate, ReportFormat reportFormat, Connection connection)
            throws JRException {
        return buildReport(reportTemplate, reportFormat, null, connection);
    }

    /**
     * Создает и возвращает файл отчета в виде массива байтов по наименованию файла шаблона.
     *
     * @param reportTemplate шаблон отчета
     * @param reportFormat   формат отчета
     * @param parameters     параметры, передаваемые в отчет
     * @return файл отчета в виде массива байтов
     * @throws JRException
     */
    public byte[] buildReport(ReportTemplate reportTemplate, ReportFormat reportFormat, Map<String, Object> parameters)
            throws JRException {
        return buildReport(reportTemplate, reportFormat, parameters, null);
    }

    /**
     * Создает и возвращает файл отчета в виде массива байтов по наименованию файла шаблона.
     *
     * @param reportTemplate шаблон отчета
     * @param reportFormat   формат отчета (напр. RTF, HTML)
     * @param parameters     параметры, передаваемые в отчет
     * @return файл отчета в виде массива байтов
     * @throws JRException
     */
    public byte[] buildReport(ReportTemplate reportTemplate, ReportFormat reportFormat, Map<String, Object> parameters,
                              Connection connection) throws JRException {
        JasperReport report = loadJasperReport(reportTemplate.getTemplateFileName());
        JasperPrint print;
        if (connection != null) {
            print = JasperFillManager.fillReport(report, parameters, connection);
        } else {
            print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        }
        return print(reportFormat, print);
    }

    /**
     * Создает и возвращает файл отчета в виде массива байтов по наименованию файла шаблона с использованием коллекции
     * Java-bean'ов
     *
     * @param reportTemplate
     * @param reportFormat
     * @param parameters
     * @param objects
     * @return
     * @throws JRException
     */
    public byte[] buildReportWithObjects(ReportTemplate reportTemplate, ReportFormat reportFormat,
                                         Map<String, Object> parameters, Collection objects) throws JRException {
        JasperReport report = loadJasperReport(reportTemplate.getTemplateFileName());
        return print(reportFormat, JasperFillManager.fillReport(report, parameters, objects == null || objects.isEmpty()
                ? new JREmptyDataSource() : new JRBeanCollectionDataSource(objects)));
    }


    private byte[] print(ReportFormat reportFormat, JasperPrint print) throws JRException {
        switch (reportFormat) {
            case RTF:
                return buildRtfReport(print);
            case DOCX:
                return buildDocxReport(print);
            case HTML:
                return buildHtmlReport(print);
            case XLS:
                return buildXlsReport(print);
            case XLSX:
                return buildXlsxReport(print);
            case CSV:
                return buildCsvReport(print);
            case XML:
                return buildXmlReport(print);
            case JPEG:
                return buildJpegReport(print);
            case ZIP_OF_JPEG:
                return buildJpegZipReport(print);
            case PDF:
                return buildPdfReport(print);
            default:
                throw new UnsupportedOperationException("Формат не поддерживается");
        }
    }

    /**
     * загружает шаблон отчета (*.jasper) из директории с шаблонами по имени файла шаблона
     */
    private JasperReport loadJasperReport(String templateName) throws JRException {
        ClassLoader cl = this.getClass().getClassLoader();
        URL reportUrl = cl.getResource(REPORT_TEMPLATES_BIN_DIRECTORY + templateName);
        return (JasperReport) JRLoader.loadObject(reportUrl);
    }

    private byte[] buildPdfReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.setConfiguration(new SimplePdfReportConfiguration());
        exporter.setConfiguration(new SimplePdfExporterConfiguration());
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    private byte[] buildRtfReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRRtfExporter exporter = new JRRtfExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
        exporter.setConfiguration(new SimpleRtfReportConfiguration());
        exporter.setConfiguration(new SimpleRtfExporterConfiguration());
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    /**
     * формирует экземпляр отчета - документ в формате DOCX, и возвращет его как поток байт
     */
    private byte[] buildDocxReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.setConfiguration(new SimpleDocxReportConfiguration());
        exporter.setConfiguration(new SimpleDocxExporterConfiguration());
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    private byte[] buildHtmlReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
        exporter.setConfiguration(new SimpleHtmlReportConfiguration());
        exporter.setConfiguration(new SimpleHtmlExporterConfiguration());
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    private byte[] buildXlsReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        SimpleXlsReportConfiguration config = new SimpleXlsReportConfiguration();
        config.setDetectCellType(true);
        config.setFontSizeFixEnabled(true);
        config.setWhitePageBackground(true);
        config.setRemoveEmptySpaceBetweenRows(true);
        exporter.setConfiguration(config);
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    private byte[] buildXlsxReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
        config.setDetectCellType(true);
        config.setFontSizeFixEnabled(true);
        config.setWhitePageBackground(true);
        config.setRemoveEmptySpaceBetweenRows(true);
        exporter.setConfiguration(config);
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    private byte[] buildCsvReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            // add BOM
            outputStream.write("\ufeff".getBytes("UTF-8"));
        } catch (IOException e) {
            //logger.warn("Не удалось использовать BOM в файле отчета csv", e);
        }
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream, "UTF-8"));
        exporter.setConfiguration(new SimpleCsvReportConfiguration());
        exporter.setConfiguration(new SimpleCsvExporterConfiguration());
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    private byte[] buildXmlReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRXmlExporter exporter = new JRXmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleXmlExporterOutput(outputStream, "UTF-8"));
        exporter.setConfiguration(new SimpleReportExportConfiguration());
        exporter.setConfiguration(new SimpleTextExporterConfiguration());
        exporter.exportReport();
        return outputStream.toByteArray();
    }

    private byte[] buildJpegReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Создаем изображение первой страницы отчета
        Image image = JasperPrintManager.printPageToImage(print, 0, 1.6f);
        try {
            ImageIO.write((RenderedImage) image, "jpg", outputStream);
        } catch (IOException e) {
            throw new JRException("Ошибка записи изображения страницы отчета", e);
        }
        return outputStream.toByteArray();
    }

    private byte[] buildJpegZipReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        try {
            for (int pageIndex = 0; pageIndex < print.getPages().size(); pageIndex++) {
                // Создаем изображение страницы отчета по ее номеру
                Image image = JasperPrintManager.printPageToImage(print, pageIndex, 1.6f);
                zipOutputStream.putNextEntry(new ZipEntry(pageIndex + ".jpg"));
                ImageIO.write((RenderedImage) image, "jpg", zipOutputStream);
                zipOutputStream.closeEntry();
            }
            zipOutputStream.close();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new JRException("Ошибка записи изображения страницы отчета", e);
        }
    }

}
