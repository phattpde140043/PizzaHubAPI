/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hello.Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tran phu phat
 */

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class User implements Serializable {
    private int UserID;
    private String FullName;
    private boolean Gender;
    private Date DOB;
    private String Phone;
    private String Address;
    private String Email;

    public User() {
    }

    public User(int UserID, String FullName, boolean Gender, Date DOB, String Phone, String Address, String Email) {
        this.UserID = UserID;
        this.FullName = FullName;
        this.Gender = Gender;
        this.DOB = DOB;
        this.Phone = Phone;
        this.Address = Address;
        this.Email = Email;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", FullName=" + FullName + ", Gender=" + Gender + ", DOB=" + DOB + ", Phone="
				+ Phone + ", Address=" + Address + ", Email=" + Email + "]";
	}
    
    
}
