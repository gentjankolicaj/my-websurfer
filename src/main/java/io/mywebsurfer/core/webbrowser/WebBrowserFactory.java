package io.mywebsurfer.core.webbrowser;

import io.mywebsurfer.core.pool.WebBrowserMap;
import io.mywebsurfer.util.DriverUtils;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

/**
 * @author gentjan koli�aj
 */
public class WebBrowserFactory {

  private static int webBrowserKey = 0;

  private WebBrowserFactory() {

  }


  public static WebBrowser[] getBrowsers(MyBrowserType... browserTypes) {
    WebBrowser[] browsersArray = new WebBrowser[browserTypes.length];
    for (int i = 0; i < browserTypes.length; i++) {
      WebDriver driver = DriverUtils.initWebDriver(browserTypes[i]);
      WebBrowser browser = new WebBrowser(driver, browserTypes[i]);
      browsersArray[i] = browser;
      WebBrowserMap.addWebBrowser(Integer.valueOf(i), browser); //saves reference to a static HashMap

    }
    return browsersArray;
  }


  public static List<WebBrowser> getBrowsers(List<MyBrowserType> browserTypes) {
    List<WebBrowser> browsersList = new ArrayList<>(browserTypes.size());
    for (int i = 0; i < browserTypes.size(); i++) {
      WebDriver driver = DriverUtils.initWebDriver(browserTypes.get(i));
      WebBrowser browser = new WebBrowser(driver, browserTypes.get(i));
      browsersList.add(browser);
      WebBrowserMap.addWebBrowser(Integer.valueOf(i), browser); //saves reference to a static HashMap
    }
    return browsersList;
  }


  public static WebBrowser getBrowser(MyBrowserType browserType) {
    WebDriver driver = DriverUtils.initWebDriver(browserType);
    WebBrowser browser = new WebBrowser(driver, browserType);
    WebBrowserMap.addWebBrowser(Integer.valueOf(webBrowserKey), browser);
    webBrowserKey++;
    return browser;
  }


}
