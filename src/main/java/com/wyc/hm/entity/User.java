package com.wyc.hm.entity;


public class User {

  private int userId;
  private String userName;
  private String password;
  private String permissionDegree;
  private String ks;
  private String phone;
  private String xb;


  public long getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getPermission() {
    return permissionDegree;
  }

  public void setPermission(String permissionDegree) {
    this.permissionDegree = permissionDegree;
  }


  public String getKs() {
    return ks;
  }

  public void setKs(String ks) {
    this.ks = ks;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getXb() {
    return xb;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

}
