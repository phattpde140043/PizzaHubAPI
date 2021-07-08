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
public class Order implements Serializable {
    private int OrderID;
    private int UserID;
    private Date CreateDate;
    private String TotalPrice;
    private String Comment;
    private String ShipAddress;
    private String PhoneAddress;
    private String OrderState;

    public Order() {
    }

    public Order(int OrderID, int UserID, Date CreateDate, String TotalPrice, String Comment, String ShipAddress, String PhoneAddress, String OrderState) {
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.CreateDate = CreateDate;
        this.TotalPrice = TotalPrice;
        this.Comment = Comment;
        this.ShipAddress = ShipAddress;
        this.PhoneAddress = PhoneAddress;
        this.OrderState = OrderState;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }

    public String getPhoneAddress() {
        return PhoneAddress;
    }

    public void setPhoneAddress(String PhoneAddress) {
        this.PhoneAddress = PhoneAddress;
    }

    public String getOrderState() {
        return OrderState;
    }

    public void setOrderState(String OrderState) {
        this.OrderState = OrderState;
    }
    
    
    
}
