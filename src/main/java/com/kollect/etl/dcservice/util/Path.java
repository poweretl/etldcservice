package com.kollect.etl.dcservice.util;

public class Path {
  
  public static class Web{
    
    public static String HOME = "/";
    public static String GET_LOGIN = "/login";
    public static String POST_LOGIN = "/login";
    public static String GET_EMAIL = "/email";
    public static String POST_EMAIL = "/email";
    
  }
  
  public static class Templates {
    public static String INDEX = "index.hbs"; 
    public static String DASHBOARD = "main.hbs";
    public static String LOGIN = "signin.hbs";
    public static String SIGN_UP = "signup.hbs";
    
}

}
