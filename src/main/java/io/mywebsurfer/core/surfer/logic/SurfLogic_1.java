package io.mywebsurfer.core.surfer.logic;

import io.mywebsurfer.core.exception.WebBrowserException;
import io.mywebsurfer.core.os.JavaProperties;
import io.mywebsurfer.core.os.OSProperties;
import io.mywebsurfer.core.os.PropertiesDetector;
import io.mywebsurfer.core.surfer.SurfResult;
import io.mywebsurfer.core.surfer.UserInfo;
import io.mywebsurfer.core.webbrowser.AbstractWebBrowser;
import io.mywebsurfer.core.website.AbstractWebSite;
import io.mywebsurfer.core.website.HelperMethods;
import java.util.ArrayList;
import java.util.List;

public class SurfLogic_1 implements Logic<SurfResult> {

  private UserInfo userInfo;
  private List<AbstractWebBrowser> webBrowsers;
  private AbstractWebSite webSite;

  public SurfLogic_1() {

  }

  @Override
  public List<SurfResult> apply(Object... objects) throws Exception {
    this.userInfo = (UserInfo) objects[0];
    this.webBrowsers = (List<AbstractWebBrowser>) objects[1];
    this.webSite = (AbstractWebSite) objects[2];

    List<SurfResult> resultList = checkBrowsers();

    addOSDetails(resultList);

    addJavaDetails(resultList);

    addUserDetails(resultList);

    //just for more user-friendly looking
    SurfResult surfDetailsTitle = new SurfResult("Surfing details :", "");
    resultList.add(surfDetailsTitle);

    goToBaseUrl(resultList);
    navigateToSubDirectories(resultList);
    return resultList;
  }

  private void addJavaDetails(List<SurfResult> resultList) {
    PropertiesDetector detector = PropertiesDetector.getInstance();
    JavaProperties javaProp = detector.getJavaProperties();
    if (javaProp != null) {
      SurfResult title = new SurfResult("JAVA Details :", "");
      SurfResult name = new SurfResult("Name", javaProp.getHome());
      SurfResult version = new SurfResult("Version", javaProp.getVersion());
      SurfResult vendor = new SurfResult("Vendor", javaProp.getVendor());

      resultList.add(title);
      resultList.add(name);
      resultList.add(version);
      resultList.add(vendor);

    }
    SurfResult empty = new SurfResult();
    resultList.add(empty);

  }

  private void addOSDetails(List<SurfResult> resultList) {
    PropertiesDetector detector = PropertiesDetector.getInstance();
    OSProperties osProp = detector.getOSProperties();
    if (osProp != null) {
      SurfResult title = new SurfResult("OS Details :", "");
      SurfResult name = new SurfResult("Name", osProp.getName());
      SurfResult version = new SurfResult("Version", osProp.getVersion());
      SurfResult arch = new SurfResult("Architecture", osProp.getArchitecture());

      resultList.add(title);
      resultList.add(name);
      resultList.add(version);
      resultList.add(arch);
    }
    SurfResult empty = new SurfResult();
    resultList.add(empty);
  }

  private void addUserDetails(List<SurfResult> resultList) {
    if (userInfo != null) {
      SurfResult title = new SurfResult("User details :", "");
      SurfResult id = new SurfResult("Id", userInfo.getId());
      SurfResult firstName = new SurfResult("FirstName", userInfo.getFirstName());
      SurfResult lastName = new SurfResult("LastName", userInfo.getLastName());
      SurfResult email = new SurfResult("Email", userInfo.getEmail());
      SurfResult password = new SurfResult("Password", userInfo.getPassword());
      SurfResult city = new SurfResult("City", userInfo.getCity());
      SurfResult country = new SurfResult("Country", userInfo.getCountry());

      resultList.add(title);
      resultList.add(id);
      resultList.add(firstName);
      resultList.add(lastName);
      resultList.add(email);
      resultList.add(password);
      resultList.add(city);
      resultList.add(country);

    }
    SurfResult empty = new SurfResult();
    resultList.add(empty);

  }

  private void navigateToSubDirectories(List<SurfResult> resultList) throws Exception {
    for (String subDirectory : webSite.getSubDirectories()) {
      navigateTo(resultList, subDirectory);

    }

  }

  private List<SurfResult> checkBrowsers() throws Exception {
    if (webBrowsers != null && webBrowsers.size() != 0) {
      return new ArrayList<>();
    } else {
      throw new WebBrowserException("Browsers reference null or 0 browsers opened.");
    }
  }


  private void goToBaseUrl(List<SurfResult> resultList) throws Exception {
    goTo(resultList, webSite.getBaseUrl());
  }


  private void goTo(List<SurfResult> resultList, String url) throws Exception {
    int nr = 0;
    for (AbstractWebBrowser var : webBrowsers) {
      HelperMethods.goTo(var.getWebDriver(), url);
      nr++;
      SurfResult result = new SurfResult();
      result.setKey(getClass().getName() + ": " + var.getBrowserType().getValue() + "-" + nr);
      result.setValue(" directed at " + url);
      resultList.add(result);
    }
    SurfResult empty = new SurfResult();
    resultList.add(empty);
  }

  private void navigateTo(List<SurfResult> resultList, String url) throws Exception {
    int nr = 0;
    for (AbstractWebBrowser var : webBrowsers) {
      HelperMethods.goTo(var.getWebDriver(), url);
      nr++;
      SurfResult result = new SurfResult();
      result.setKey(getClass().getName() + ": " + var.getBrowserType().getValue() + "-" + nr);
      result.setValue(" navigate to " + url);
      resultList.add(result);
    }
    SurfResult empty = new SurfResult();
    resultList.add(empty);

  }


}
