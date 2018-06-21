/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author g16934os
 */
public class Income implements Serializable{
    private String income;
    
    public Income(){}
    public Income(String income){
        this.income = income;
    }
    public String getIncome(){return income;}
    
}
