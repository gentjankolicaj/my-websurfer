package io.mywebsurfer.core.webbrowser;

import io.mywebsurfer.core.pool.WebBrowserMap;
import java.util.List;
import java.util.Map;

/**
 * @author gentjan koli�aj
 */
public class WebBrowserUtils {

  public static void closeWindow(List<AbstractWebBrowser> list) {
    for (AbstractWebBrowser var : list) {
      var.webDriver.close();
    }
  }

  public static void closeWindow(AbstractWebBrowser[] array) {
    for (AbstractWebBrowser var : array) {
      var.webDriver.close();
    }
  }


  public static void quit(List<AbstractWebBrowser> list) {
    for (AbstractWebBrowser var : list) {
      var.webDriver.quit();
    }
  }

  public static void quit(AbstractWebBrowser[] array) {
    for (AbstractWebBrowser var : array) {
      var.webDriver.quit();
    }

  }

  public static void quit() {
    Map<Integer, AbstractWebBrowser> map = WebBrowserMap.getWebBrowserReferences();
    for (Map.Entry<Integer, AbstractWebBrowser> entry : map.entrySet()) {
      entry.getValue().webDriver.quit();
    }

  }


  public static void close() {
    Map<Integer, AbstractWebBrowser> map = WebBrowserMap.getWebBrowserReferences();
    for (Map.Entry<Integer, AbstractWebBrowser> entry : map.entrySet()) {
      entry.getValue().webDriver.close();
    }

  }


}
