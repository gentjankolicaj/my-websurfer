package io.mywebsurfer.core.os;

/**
 * @author gentjan koli�aj
 */
public class PropertiesDetector {

  private static PropertiesDetector instance;

  //OS related members
  private static final String osName;
  private static final String osVersion;
  private static final String osArchitecture;
  private static final String osFileSeparator;

  //User related members
  private static final String userName;
  private static final String userWorkDir;
  private static final String userHomeDir;
  private static final String userCountry;
  private static final String userLanguage;
  private static final String userTimeZone;

  //Java related members
  private static final String javaHome;
  private static final String javaVersion;
  private static final String javaVendor;
  private static final String sunJnuEncoding;
  private static final String javaClassPath;
  private static final String javaClassVersion;

  private static final String vmName;
  private static final String vmVersion;
  private static final String vmInfo;

  private static final String runtimeName;
  private static final String runtimeVersion;

  static {
    // OS properties
    osName = System.getProperty("os.name");
    osVersion = System.getProperty("os.version");
    osArchitecture = System.getProperty("os.arch");
    osFileSeparator = System.getProperty("file.separator");

    // OS user properties
    userWorkDir = System.getProperty("user.dir");
    userHomeDir = System.getProperty("user.home");
    userName = System.getProperty("user.name");
    userCountry = System.getProperty("user.country");
    userLanguage = System.getProperty("user.language");
    userTimeZone = System.getProperty("user.timezone");

    // JAVA properties
    javaHome = System.getProperty("java.home");
    javaVersion = System.getProperty("java.version");
    javaVendor = System.getProperty("java.vendor");
    sunJnuEncoding = System.getProperty("sun.jnu.encoding");
    javaClassPath = System.getProperty("java.class.path");
    javaClassVersion = System.getProperty("java.class.version");

    vmName = System.getProperty("java.vm.name");
    vmVersion = System.getProperty("java.vm.version");
    vmInfo = System.getProperty("java.vm.info");

    runtimeName = System.getProperty("java.runtime.name");
    runtimeVersion = System.getProperty("java.runtime.version");


  }

  private PropertiesDetector() {

  }

  public static PropertiesDetector getInstance() {
    if (instance == null) {
      instance = new PropertiesDetector();
      return instance;
    } else {
      return instance;
    }
  }


  public JavaProperties getJavaProperties() {
    return new JavaProperties(javaHome, javaVersion, javaVendor, sunJnuEncoding, javaClassPath,
        javaClassVersion, vmName, vmVersion, vmInfo, runtimeName, runtimeVersion);
  }

  public OSUserProperties getOSUserProperties() {
    return new OSUserProperties(userName, userWorkDir, userHomeDir, userCountry, userLanguage,
        userTimeZone);
  }


  public OSProperties getOSProperties() {
    return new OSProperties(osName, osVersion, osArchitecture, osFileSeparator);
  }


}
