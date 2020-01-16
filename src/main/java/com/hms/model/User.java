package com.hms.model;


public class User {
  public User() {
    super();
  }
  
  private int userId;
  private String userName;
  private String userPassword;
  private int userAge;
  private String userGender;
  private String userMobileNumber;
  private String userEmailId;
  private String userAddressLine1;
  private String userAddressLine2;
  private String userAddressLine3;
  private int userRoleId;
  
  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getUserPassword() {
    return userPassword;
  }
  
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  
  public int getUserAge() {
    return userAge;
  }
  
  public void setUserAge(int userAge) {
    this.userAge = userAge;
  }
  
  public String getUserGender() {
    return userGender;
  }
  
  public void setUserGender(String userGender) {
    this.userGender = userGender;
  }
  
  public String getUserMobileNumber() {
    return userMobileNumber;
  }
  
  public void setUserMobileNumber(String userMobileNumber) {
    this.userMobileNumber = userMobileNumber;
  }
  
  public String getUserEmailId() {
    return userEmailId;
  }
  
  public void setUserEmailId(String userEmailId) {
    this.userEmailId = userEmailId;
  }
  
  public String getUserAddressLine1() {
    return userAddressLine1;
  }
  
  public void setUserAddressLine1(String userAddressLine1) {
    this.userAddressLine1 = userAddressLine1;
  }
  
  public String getUserAddressLine2() {
    return userAddressLine2;
  }
  
  public void setUserAddressLine2(String userAddressLine2) {
    this.userAddressLine2 = userAddressLine2;
  }
  
  public String getUserAddressLine3() {
    return userAddressLine3;
  }
  
  public void setUserAddressLine3(String userAddressLine3) {
    this.userAddressLine3 = userAddressLine3;
  }
  
  public int getUserRoleId() {
    return userRoleId;
  }
  
  public void setUserRoleId(int userRoleId) {
    this.userRoleId = userRoleId;
  }
  
  public int getUserId() {
    return userId;
  }
  
  public void setUserId(int userId) {
    this.userId = userId;
  }
  
  @Override
  public String toString() {
    return "User [userId=" + userId + ", userName=" + userName
        + ", userPassword=" + userPassword + ", userAge=" + userAge
        + ", userGender=" + userGender + ", userMobileNumber="
        + userMobileNumber + ", userEmailId=" + userEmailId
        + ", userAddressLine1=" + userAddressLine1 + ", userAddressLine2="
        + userAddressLine2 + ", userAddressLine3=" + userAddressLine3
        + ", userRoleId=" + userRoleId + "]";
  }

}
