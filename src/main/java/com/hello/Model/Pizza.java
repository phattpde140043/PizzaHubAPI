/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hello.Model;

import java.io.Serializable;

/**
 *
 * @author tran phu phat
 */
public class Pizza implements Serializable {
    private int PizzaID;
    private String PizzaName;
    private String Image;
    private String Description;
    private String Price;

    public Pizza() {
    }

    public Pizza(int PizzaID, String PizzaName, String Image, String Description, String Price) {
        this.PizzaID = PizzaID;
        this.PizzaName = PizzaName;
        this.Image = Image;
        this.Description = Description;
        this.Price = Price;
    }

    public int getPizzaID() {
        return PizzaID;
    }

    public void setPizzaID(int PizzaID) {
        this.PizzaID = PizzaID;
    }

    public String getPizzaName() {
        return PizzaName;
    }

    public void setPizzaName(String PizzaName) {
        this.PizzaName = PizzaName;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
    
    
}
