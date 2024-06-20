package io.mywebsurfer;

import io.mywebsurfer.core.surfer.InternetUser;
import io.mywebsurfer.core.surfer.SurfResult;
import io.mywebsurfer.core.surfer.UserInfo;
import io.mywebsurfer.core.surfer.logic.SurfLogic_1;
import io.mywebsurfer.core.webbrowser.MyBrowserType;
import io.mywebsurfer.core.webbrowser.WebBrowser;
import io.mywebsurfer.core.webbrowser.WebBrowserFactory;
import io.mywebsurfer.core.webbrowser.WebBrowserUtils;
import io.mywebsurfer.core.website.WebSite;
import io.mywebsurfer.report.ReportUtils;
import io.mywebsurfer.task.Task;
import io.mywebsurfer.util.DriverUtils;
import java.util.Arrays;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class Application {

  public static void main(String[] args) {

    task1();
  }

  public static void task1() {
    Task task = new Task();
    task.addStep(() -> {

      UserInfo userInfo = new UserInfo("005", "john", "doe", "005@testing.com",
          "@deeptrouble", "London", "UK");

      String baseUrl = "https://www.seleniumhq.org/";
      String[] subDirectories = {"https://www.seleniumhq.org/projects/",
          "https://www.seleniumhq.org/download/", "https://www.seleniumhq.org/docs/",
          "https://www.seleniumhq.org/support/", "https://www.seleniumhq.org/about/"};

      WebSite webSite = new WebSite();
      webSite.setBaseUrl(baseUrl);
      webSite.setSubDirectories(Arrays.asList(subDirectories));

      WebBrowser[] webBrowsers = WebBrowserFactory.getBrowsers(MyBrowserType.CHROME,
          MyBrowserType.CHROME);

      InternetUser user = new InternetUser();
      user.setUserInfo(userInfo);
      user.setBrowsers(webBrowsers);
      user.setWebSite(webSite);

      //Sets the logic implemented for surfing,in order to have other logic of surfing
      //you must implement Logic interface and make changes to surf() method.
      user.setLogic(new SurfLogic_1());

      List<SurfResult> surfResult = user.surf();

      //saves results in xlsx file in user's home directory
      ReportUtils.saveResults(surfResult, "SurfReport");
    });

    try {
      task.finish();
    } catch (Exception e) {
      WebBrowserUtils.quit();
      DriverUtils.killDrivers();
      e.printStackTrace();
    }
  }

}
