package io.mywebsurfer.core.surfer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gentjan koli�aj
 */
public class UserInfo implements SurferInfo {

  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String city;
  private String country;

  public UserInfo() {
    super();
    // TODO Auto-generated constructor stub
  }

  public UserInfo(String id, String firstName, String lastName, String email, String password,
      String city,
      String country) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.city = city;
    this.country = country;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public String toString() {
    return "UserInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
        + email
        + ", password=" + password + ", city=" + city + ", country=" + country + "]";
  }


  @Override
  public List<Object> getSurferInfo() {
    List<Object> infoList = new ArrayList<>();
    infoList.add(id);
    infoList.add(firstName);
    infoList.add(lastName);
    infoList.add(email);
    infoList.add(city);
    infoList.add(password);

    return infoList;
  }


}
