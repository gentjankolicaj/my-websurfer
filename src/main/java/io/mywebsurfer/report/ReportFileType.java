package io.mywebsurfer.report;

/**
 * @author gentjan koli�aj
 */
public enum ReportFileType {

  XLS("XLS", "xls"), XLSX("XLSX", "xlsx");

  private final String fileType;
  private final String fileExtension;

  ReportFileType(String fileType, String fileExtension) {
    this.fileType = fileType;
    this.fileExtension = fileExtension;
  }

  public String getFileType() {
    return fileType;
  }

  public String getFileExtension() {
    return fileExtension;
  }


}
