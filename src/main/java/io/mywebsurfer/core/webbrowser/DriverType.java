package io.mywebsurfer.core.webbrowser;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.SystemUtils;

@RequiredArgsConstructor
@Getter
public enum DriverType {

  CHROME_DRIVER("chromedriver", "webdriver.chrome.driver"),
  GECKO_DRIVER("geckodriver", "webdriver.gecko.driver"),
  HTML_UNIT_DRIVER("htmlunit-driver-2.33.3.jar", "htmlunit.binary.path"),
  EDGE_DRIVER("MicrosoftWebDriver", "webdriver.edge.driver");

  private final String driverFile;
  private final String driverName;


  public String getDriverFile() {
    String os = SystemUtils.OS_NAME.toLowerCase();
    if (os.contains("linux") || os.contains("mac")) {
      return driverFile;
    } else if (os.contains("windows")) {
      return driverFile + ".exe";
    }
    throw new IllegalStateException("Can't find os type driver");
  }

}
