package io.mywebsurfer.core.website;

import java.util.List;

public class WebPage {

  protected String pageName;
  protected String pageTitle;
  protected List<HtmlTag> htmlTags;

  public WebPage() {
    super();
    // TODO Auto-generated constructor stub
  }

  public String getPageName() {
    return pageName;
  }

  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  public String getPageTitle() {
    return pageTitle;
  }

  public void setPageTitle(String pageTitle) {
    this.pageTitle = pageTitle;
  }

  public List<HtmlTag> getHtmlTags() {
    return htmlTags;
  }

  public void setHtmlTags(List<HtmlTag> htmlTags) {
    this.htmlTags = htmlTags;
  }


}
