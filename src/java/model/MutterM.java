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
public class MutterM implements Serializable{
    //private int id;
    private String MuserName;
    private String Mage;
    private String Mincome;
    public MutterM(){}
    public MutterM(String MuserName, String Mage, String Mincome){
        this.MuserName = MuserName;
        this.Mage = Mage;
        this.Mincome = Mincome;
    }
    /*public MutterM(int id, String MuserName, String Mage, String Mincome){
        this.id = id;
        this.MuserName = MuserName;
        this.Mage = Mage;
        this.Mincome = Mincome;
    }*/
    //public int getId(){ return id; }
    public String getMIncome(){ return Mincome; }
    public String getMUserName(){
        return MuserName;
    }
    public String getMAge(){
        return Mage;
    }
}
