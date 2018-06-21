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
public class LoginLogic {
     public boolean execute(User user) {
        if (user.getPass().equals("1234")) { return true; }
        return false;
    }
}
