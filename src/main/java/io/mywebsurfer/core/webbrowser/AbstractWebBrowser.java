package io.mywebsurfer.core.webbrowser;

import org.openqa.selenium.WebDriver;

public abstract class AbstractWebBrowser {

  protected WebDriver webDriver;
  protected MyBrowserType browserType;

  public AbstractWebBrowser(WebDriver webDriver, MyBrowserType browserType) {
    super();
    this.webDriver = webDriver;
    this.browserType = browserType;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  public MyBrowserType getBrowserType() {
    return browserType;
  }


}
