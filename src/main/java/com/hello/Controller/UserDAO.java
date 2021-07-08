/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hello.Controller;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.hello.Model.User;

/**
 *
 * @author tran phu phat
 */

@Repository
public class UserDAO implements DatabaseInfo {

    private boolean CheckExistUserName(String Username) {
        boolean result = false;
        try {
            Class.forName(driverName);
            try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                PreparedStatement stmt = con.prepareStatement("Select count(*) from Login where UserName =?");
                stmt.setString(1, Username);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    result = (count == 0);
                }
                con.close();
            }
            return result;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class UserDAO- function: CheckExistUserName");
            System.err.println(e);
            return result;
        }
    }

    private int GetIdByUserName(String Username) {
        int result = -1;
        try {
            Class.forName(driverName);
            try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                PreparedStatement stmt = con.prepareStatement("Select ID from Login where UserName =?");
                stmt.setString(1, Username);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    result = rs.getInt(1);
                }
                con.close();
            }
            return result;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class UserDAO- function: CheckExistUserName");
            System.err.println(e);
            return result;
        }
    }
    
    private String GetUserNameById(int id) {
        String result = null;
        try {
            Class.forName(driverName);
            try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                PreparedStatement stmt = con.prepareStatement("Select UserName from Login where ID =?");
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    result = rs.getString(1);
                }
                con.close();
            }
            return result;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class UserDAO- function: GetUserNameById");
            System.err.println(e);
            return null;
        }
    }

    public boolean CreateNewAccount(String UserName, String Password) {
        boolean result = false;
        try {
            Class.forName(driverName);
            int rc = -1;
            try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                if (CheckExistUserName(UserName)) {
                    PreparedStatement stmt = con.prepareStatement("Insert into login(UserName,Password) values (?,?)");
                    stmt.setString(1, UserName);
                    stmt.setString(2, Password);
                    rc = stmt.executeUpdate();
                }
                con.close();
            }
            if (rc == 1) {
                try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                    PreparedStatement stmt = con.prepareStatement("Insert into UserInfo(ID,FullName,Gender,DOP,Phone,Address,Email,RegisterDate) values(?,'',0,GETDATE(),'','','',GETDATE())");
                    stmt.setInt(1, GetIdByUserName(UserName));
                    rc = stmt.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    System.err.println("Class UserDAO- function: Create new row in user info");
                    System.err.println(e);

                }
            }
            return rc == 1;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class UserDAO- function: Create new account");
            System.err.println(e);
            return false;
        }
    }

    public String GetAccountByUserName(String UserName) {
        String result = null;
        try {
            Class.forName(driverName);
            try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                PreparedStatement stmt = con.prepareStatement("Select Password from Login where UserName =?");
                stmt.setString(1, UserName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    result = rs.getString(1);
                }
                con.close();
            }
            return result;
        } catch (Exception e) {
        	e.printStackTrace();
            System.err.println("Class UserDAO- function: GetAccountByUserName");
            System.err.println(e);
            return null;
        }
    }
    
    public User GetUserinfoByUserName(String UserName) {
        User result = null;
        try {
            Class.forName(driverName);
            
            try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                PreparedStatement stmt = con.prepareStatement("Select ID,FullName, Gender, DOP,Phone,Address,Email from UserInfo where ID= ?");
                stmt.setInt(1, GetIdByUserName(UserName));
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    result = new  User(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
                }
                con.close();
            }
            return result;
        } catch (Exception e) {
        	e.printStackTrace();
            System.err.println("Class UserDAO- function: GetUserInfoByUserName");
            System.err.println(e);
            return null;
        }
    }
    
    public User UpdateUserInfo(User us) {
        try {
            Class.forName(driverName);
            int rc = -1;
            try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB)) {
                PreparedStatement stmt = con.prepareStatement("Update UserInfo set FullName=?,Gender=?,DOP=?,Phone=?,Address=?,Email=? where ID=?");
                stmt.setString(1, us.getFullName());
                stmt.setBoolean(2, us.isGender());
                stmt.setDate(3, new java.sql.Date(us.getDOB().getTime()));
                stmt.setString(4, us.getPhone());
                stmt.setString(5, us.getAddress());
                stmt.setString(6, us.getEmail());
                stmt.setInt(7, us.getUserID());
                rc = stmt.executeUpdate();
                con.close();
            }
            if(rc==1) {
            	return GetUserinfoByUserName(GetUserNameById(us.getUserID()));
            }
        } catch (Exception e) {
        	e.printStackTrace();
            System.err.println("Class UserDAO- function: UpdateUserinfo");
            System.err.println(e);
            return null;
        }
		return null;
    }

}
