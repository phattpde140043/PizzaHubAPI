package com.hello.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tran phu phat
 */
public interface DatabaseInfo {

    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=PizzaHub;encrypt=true;trustServerCertificate=true";
    public static String userDB = "phattp";
    public static String passDB = "abcd";
}
