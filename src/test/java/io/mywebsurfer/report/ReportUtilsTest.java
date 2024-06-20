package io.mywebsurfer.report;

import io.mywebsurfer.config.GlobalConfig;
import io.mywebsurfer.core.surfer.SurfResult;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReportUtilsTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testSaveXLSResults() throws Exception {
    GlobalConfig.ReportFile = ReportFileType.XLSX;
    List<SurfResult> list = Arrays.asList(new SurfResult("firstName", "john"),
        new SurfResult("Lastname", "doe"),
        new SurfResult("age", "24"), new SurfResult("code", "007"));

    ReportUtils.saveResults(list, "testFile");
    ReportUtils.saveResults(list, "testFile");
    ReportUtils.saveResults(list, "testFile");
    ReportUtils.saveResults(list, "testFile");

  }

  @Test
  public void testSaveXLSSResults() throws Exception {
    GlobalConfig.ReportFile = ReportFileType.XLS;
    List<SurfResult> list = Arrays.asList(new SurfResult("firstName", "jone"),
        new SurfResult("Lastname", "doe"),
        new SurfResult("age", "23"), new SurfResult("code", "006"));

    ReportUtils.saveResults(list, "testFile");
    ReportUtils.saveResults(list, "testFile");
    ReportUtils.saveResults(list, "testFile");
    ReportUtils.saveResults(list, "testFile");

  }

}
