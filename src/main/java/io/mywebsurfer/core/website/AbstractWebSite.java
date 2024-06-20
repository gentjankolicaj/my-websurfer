package io.mywebsurfer.core.website;

import java.util.List;

/**
 * @author gentjan koli�aj
 */
public abstract class AbstractWebSite {

  protected String server;
  protected int port;
  protected String baseUrl;
  protected List<String> subDirectories;


  /**
   *
   */
  public AbstractWebSite() {
    super();
    // TODO Auto-generated constructor stub
  }


  public AbstractWebSite(String server, int port, String baseUrl, List<String> subDirectories) {
    super();
    this.server = server;
    this.port = port;
    this.baseUrl = baseUrl;
    this.subDirectories = subDirectories;
  }


  public String getServer() {
    return server;
  }


  public void setServer(String server) {
    this.server = server;
  }


  public int getPort() {
    return port;
  }


  public void setPort(int port) {
    this.port = port;
  }


  public String getBaseUrl() {
    return baseUrl;
  }


  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }


  public List<String> getSubDirectories() {
    return subDirectories;
  }


  public void setSubDirectories(List<String> subDirectories) {
    this.subDirectories = subDirectories;
  }


}
