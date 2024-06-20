package io.mywebsurfer.config;

import io.mywebsurfer.report.ReportFileType;
import java.util.concurrent.TimeUnit;

/**
 * @author gentjan koli�aj
 */
public class GlobalConfig {

  //Time unit config
  public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
  //Chrome browser timeout config
  public static final int C_TIMEOUT = 5000;
  //Firefox browser timeout config
  public static final int F_TIMEOUT = 5000;
  //Edge browser timeout config
  public static final int E_TIMEOUT = 5000;
  //HtmlUnit browser timeout config
  public static final int H_TIMEOUT = 5000;

  public static String homeDirectory = System.getProperty("user.dir");
  public static String fileSeparator = System.getProperty("file.separator");

  //Config for saving surfing results
  public static boolean SaveSurfResults = true;
  public static ReportFileType ReportFile = ReportFileType.XLSX;

  //default sheet name for every xls,xlsx file.
  public static String sheetName = "report_sheet";

  public static String getDriversPath() {
    return GlobalConfig.class.getClassLoader().getResource("drivers").getPath();
  }

}
