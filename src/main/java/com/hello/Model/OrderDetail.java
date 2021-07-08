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
public class OrderDetail implements Serializable {
    private int OrderID;
    private int PizzaID;
    private int Quantity;
    private int Size;

    public OrderDetail() {
    }

    public OrderDetail(int OrderID, int PizzaID, int Quantity, int Size) {
        this.OrderID = OrderID;
        this.PizzaID = PizzaID;
        this.Quantity = Quantity;
        this.Size = Size;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getPizzaID() {
        return PizzaID;
    }

    public void setPizzaID(int PizzaID) {
        this.PizzaID = PizzaID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }
    
    
    
}
