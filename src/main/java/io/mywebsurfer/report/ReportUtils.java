package io.mywebsurfer.report;

import io.mywebsurfer.config.GlobalConfig;
import io.mywebsurfer.core.surfer.SurfResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.maven.shared.utils.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportUtils {

  private static OutputStream outputStream;
  private static int fileNumber = 0;


  public static void saveResults(List<SurfResult> list, String fileName) throws Exception {
    if (GlobalConfig.SaveSurfResults) {
      if (GlobalConfig.ReportFile.equals(ReportFileType.XLSX)) {

        saveResultsToXlsx(list, fileName, GlobalConfig.ReportFile);

      } else if (GlobalConfig.ReportFile.equals(ReportFileType.XLS)) {

        saveResultsToXls(list, fileName, GlobalConfig.ReportFile);
      }
    }

  }

  private static void saveResultsToXlsx(List<SurfResult> list, String fileName,
      ReportFileType fileType)
      throws Exception {

    handleFileCollision(fileName, fileType);

    XSSFWorkbook workbook = new XSSFWorkbook();

    XSSFSheet sheet = workbook.createSheet(GlobalConfig.sheetName);

    Row row;
    Cell cell1;
    Cell cell0;

    for (int r = 0; r < list.size(); r++) {
      SurfResult tmp = list.get(r);
      row = sheet.createRow(r);

      cell0 = row.createCell(0);
      cell0.setCellValue(tmp.getKey());

      cell1 = row.createCell(1);
      cell1.setCellValue(tmp.getValue());
    }

    workbook.write(outputStream);
    workbook.close();

    outputStream.flush();
    outputStream.close();

  }

  private static void saveResultsToXls(List<SurfResult> list, String fileName,
      ReportFileType fileType)
      throws Exception {

    handleFileCollision(fileName, fileType);

    Workbook workbook = WorkbookFactory.create(
        false); // False argument results in creation of HSSFWorkbook object

    Sheet sheet = workbook.createSheet(GlobalConfig.sheetName);

    Row row;
    Cell cell1;
    Cell cell0;

    for (int r = 0; r < list.size(); r++) {
      SurfResult tmp = list.get(r);
      row = sheet.createRow(r);

      cell0 = row.createCell(0);
      cell0.setCellValue(tmp.getKey());

      cell1 = row.createCell(1);
      cell1.setCellValue(tmp.getValue());
    }

    workbook.write(outputStream);
    workbook.close();

    outputStream.flush();
    outputStream.close();

  }

  private static String buildFilePath(String fileName, ReportFileType fileType) {
    return GlobalConfig.homeDirectory + GlobalConfig.fileSeparator + fileName + "_" + fileNumber
        + "." + fileType.getFileExtension();
  }


  private static void handleFileCollision(String fileName, ReportFileType fileType)
      throws Exception {
    String filePath = buildFilePath(fileName, fileType);
    File fileObject = new File(filePath);
    while (fileObject.exists()) {
      String fullFileName = fileObject.getName().trim();
      String name = StringUtils.substring(fullFileName, 0, fullFileName.indexOf("."));
      String number = StringUtils.substring(name, name.lastIndexOf("_") + 1, name.length());
      fileNumber = Integer.valueOf(number) + 1;
      filePath = buildFilePath(fileName, fileType);
      fileObject = new File(filePath);
    }
    outputStream = new FileOutputStream(filePath);

  }


}
