package io.mywebsurfer.core.os;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PropertiesDetectorTest {


  @Test
  public void testGetInstance() {
    PropertiesDetector instance = PropertiesDetector.getInstance();
    assertNotNull(instance);
  }

  @Test
  public void testGetJavaProperties() {
    PropertiesDetector instance = PropertiesDetector.getInstance();
    JavaProperties javaProp = instance.getJavaProperties();
    assertNotNull(javaProp);

    System.out.println(javaProp);
    System.out.println();

  }

  @Test
  public void testGetOSUserProperties() {
    PropertiesDetector instance = PropertiesDetector.getInstance();
    OSUserProperties osUserProp = instance.getOSUserProperties();
    assertNotNull(osUserProp);

    System.out.println(osUserProp);
    System.out.println();
  }

  @Test
  public void testGetOSProperties() {
    PropertiesDetector instance = PropertiesDetector.getInstance();
    OSProperties osProp = instance.getOSProperties();
    assertNotNull(osProp);

    System.out.println(osProp);
    System.out.println();
  }

}
