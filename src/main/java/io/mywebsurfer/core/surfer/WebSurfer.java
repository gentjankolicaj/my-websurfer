package io.mywebsurfer.core.surfer;

import io.mywebsurfer.core.webbrowser.AbstractWebBrowser;
import io.mywebsurfer.core.website.AbstractWebSite;
import java.util.List;

/**
 * @author gentjan koli�aj
 */
public abstract class WebSurfer implements Surfable<SurfResult> {


  public abstract List<AbstractWebBrowser> setBrowsers(List<AbstractWebBrowser> browsers)
      throws Exception;

  public abstract AbstractWebBrowser[] setBrowsers(AbstractWebBrowser[] browsers) throws Exception;

  public abstract AbstractWebSite setWebSite(AbstractWebSite abstractWebSite) throws Exception;


}
