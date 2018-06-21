/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g16934os
 */
public class MutterW {
       //private int id;
    private String WuserName;
    private String Wage;
    private String Wincome;
    public MutterW(){}
    public MutterW(String WuserName, String Wage, String Wincome){
        this.WuserName = WuserName;
        this.Wage = Wage;
        this.Wincome = Wincome;
    }
    /*public MutterM(int id, String userName,String text){
        this.MuserName = MuserName;
        this.Mage = Mage;
        this.Mincome = Mincome;
    }*/
    public String getWIncome(){ return Wincome; }
    public String getWUserName(){
        return WuserName;
    }
    public String getWAge(){
        return Wage;
    }
}
