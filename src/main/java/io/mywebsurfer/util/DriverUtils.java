package io.mywebsurfer.util;

import io.mywebsurfer.config.GlobalConfig;
import io.mywebsurfer.core.webbrowser.DriverType;
import io.mywebsurfer.core.webbrowser.MyBrowserType;
import java.io.IOException;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author gentjan koli�aj
 */
public class DriverUtils {

  public static WebDriver initWebDriver(MyBrowserType browserType) {
    WebDriver tmp = null;
    switch (browserType) {
      case CHROME:
        tmp = initChrome(DriverType.CHROME_DRIVER);
        break;
      case FIREFOX:
        tmp = initFirefox(DriverType.GECKO_DRIVER);
        break;
      case HTML_UNIT:
        tmp = initHtmlUnit(DriverType.HTML_UNIT_DRIVER);
        break;
      case EDGE:
        tmp = initEdge(DriverType.EDGE_DRIVER);
        break;

    }
    return tmp;

  }

  private static WebDriver initChrome(DriverType driverType) {
    System.setProperty(driverType.getDriverName(), findDriverPath(driverType));
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(GlobalConfig.C_TIMEOUT, GlobalConfig.TIME_UNIT);
    return driver;
  }

  private static WebDriver initFirefox(DriverType driverType) {
    System.setProperty(driverType.getDriverName(), findDriverPath(driverType));
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(GlobalConfig.F_TIMEOUT, GlobalConfig.TIME_UNIT);
    return driver;
  }

  private static WebDriver initEdge(DriverType driverType) {
    System.setProperty(driverType.getDriverName(), findDriverPath(driverType));
    WebDriver driver = new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(GlobalConfig.E_TIMEOUT, GlobalConfig.TIME_UNIT);
    return driver;
  }

  private static WebDriver initHtmlUnit(DriverType driverType) {
    System.setProperty(driverType.getDriverName(), findDriverPath(driverType));
    WebDriver driver = new HtmlUnitDriver();
    driver.manage().timeouts().implicitlyWait(GlobalConfig.H_TIMEOUT, GlobalConfig.TIME_UNIT);
    return driver;
  }

  public static String findDriverPath(DriverType driverType) {
    return GlobalConfig.getDriversPath() + GlobalConfig.fileSeparator + driverType.getDriverFile();
  }


  public static void killDrivers() {
    String os = SystemUtils.OS_NAME.toLowerCase();
    if (os.contains("linux") || os.contains("mac")) {
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try {
          Runtime.getRuntime().exec("killall -9 " + DriverType.CHROME_DRIVER.getDriverFile());
          Runtime.getRuntime().exec("killall -9 " + DriverType.EDGE_DRIVER.getDriverFile());
          Runtime.getRuntime().exec("killall -9  " + DriverType.GECKO_DRIVER.getDriverFile());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }));
    } else if (os.contains("windows")) {
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try {
          Runtime.getRuntime().exec("TASKKILL /F /IM " + DriverType.CHROME_DRIVER.getDriverFile());
          Runtime.getRuntime().exec("TASKKILL /F /IM " + DriverType.EDGE_DRIVER.getDriverFile());
          Runtime.getRuntime().exec("TASKKILL /F /IM " + DriverType.GECKO_DRIVER.getDriverFile());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }));
    }
  }

}
