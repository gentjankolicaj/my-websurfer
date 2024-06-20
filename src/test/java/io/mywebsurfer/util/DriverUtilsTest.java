package io.mywebsurfer.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import io.mywebsurfer.core.webbrowser.DriverType;
import io.mywebsurfer.core.webbrowser.MyBrowserType;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DriverUtilsTest {


  @Test
  public void testInitWebDriver() {
    WebDriver driver = DriverUtils.initWebDriver(MyBrowserType.CHROME);
    assertNotNull(driver);


  }

  @Test
  public void findDriverPath() {
    String path = DriverUtils.findDriverPath(DriverType.CHROME_DRIVER);
    assertTrue(path, path.contains("chromedriver"));

    String path1 = DriverUtils.findDriverPath(DriverType.GECKO_DRIVER);
    assertTrue(path1, path1.contains("geckodriver"));
  }

}
