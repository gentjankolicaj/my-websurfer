package io.mywebsurfer.core.surfer;

import io.mywebsurfer.core.surfer.logic.Logic;
import io.mywebsurfer.core.webbrowser.AbstractWebBrowser;
import io.mywebsurfer.core.website.AbstractWebSite;
import java.util.Arrays;
import java.util.List;

/**
 * @author gentjan koli�aj
 */
public class InternetUser extends WebSurfer {

  private UserInfo userInfo;
  private List<AbstractWebBrowser> webBrowsers;
  private Logic logic;
  private AbstractWebSite abstractWebSite;

  public InternetUser() {
    super();
    // TODO Auto-generated constructor stub
  }


  public InternetUser(UserInfo userInfo, List<AbstractWebBrowser> webBrowsers, Logic logic) {
    super();
    this.userInfo = userInfo;
    this.webBrowsers = webBrowsers;
    this.logic = logic;
  }


  public UserInfo getUserInfo() {
    return userInfo;
  }


  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }


  public List<AbstractWebBrowser> getWebBrowsers() {
    return webBrowsers;
  }


  public void setWebBrowsers(List<AbstractWebBrowser> webBrowsers) {
    this.webBrowsers = webBrowsers;
  }


  public void setLogic(Logic logic) {
    this.logic = logic;
  }


  public List<Object> getSurferInfo() {
    if (userInfo != null) {
      return userInfo.getSurferInfo();
    } else {
      return null;
    }
  }

  @Override
  public List<SurfResult> surf() throws Exception {
    return (List<SurfResult>) logic.apply(userInfo, webBrowsers, abstractWebSite);
  }


  @Override
  public List<AbstractWebBrowser> setBrowsers(List<AbstractWebBrowser> browsers) throws Exception {
    this.webBrowsers = browsers;
    return webBrowsers;
  }

  @Override
  public AbstractWebBrowser[] setBrowsers(AbstractWebBrowser[] browsers) throws Exception {
    this.webBrowsers = Arrays.asList(browsers);
    return browsers;
  }

  @Override
  public AbstractWebSite setWebSite(AbstractWebSite abstractWebSite) throws Exception {
    this.abstractWebSite = abstractWebSite;
    return abstractWebSite;
  }


}
