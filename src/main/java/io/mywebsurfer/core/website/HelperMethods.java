package io.mywebsurfer.core.website;

import org.openqa.selenium.WebDriver;

/**
 * @author gentjan koli�aj
 */
public class HelperMethods {

  private static WebDriver driver;

  private HelperMethods() {
  }

  public static void goTo(WebDriver driver, String url) throws Exception {
    driver.get(url);
  }


  public static void naviateTo(WebDriver driver, String url) throws Exception {
    driver.navigate().to(url);
  }

  public static void refresh(WebDriver driver) throws Exception {
    driver.navigate().refresh();
  }

  public static void backward(WebDriver driver) throws Exception {
    driver.navigate().back();
  }

  public static void forward(WebDriver driver) throws Exception {
    driver.navigate().forward();
  }


}
