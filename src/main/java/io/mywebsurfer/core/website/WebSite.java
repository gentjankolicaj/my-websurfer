package io.mywebsurfer.core.website;

import java.util.List;

/**
 * @author gentjan koli�aj
 */
public class WebSite extends AbstractWebSite {

  protected List<WebPage> webPages;

  public WebSite() {
    super();
    // TODO Auto-generated constructor stub
  }

  public WebSite(String server, int port, String baseUrl, List<String> subDirectories) {
    super(server, port, baseUrl, subDirectories);
    // TODO Auto-generated constructor stub
  }

  public List<WebPage> getWebPages() {
    return webPages;
  }

  public void setWebPages(List<WebPage> webPages) {
    this.webPages = webPages;
  }


}
