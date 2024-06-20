package io.mywebsurfer.core.surfer;

public class SurfResult {

  private String key;
  private String value;

  public SurfResult() {
    super();
    // TODO Auto-generated constructor stub
  }

  public SurfResult(String key, String value) {
    super();
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "SurfResult [key=" + key + ", value=" + value + "]";
  }

}
