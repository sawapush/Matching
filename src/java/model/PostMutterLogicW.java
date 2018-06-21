/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterWDAO;

/**
 *
 * @author g16934os
 */
public class PostMutterLogicW {
    public void execute(MutterW mutterW){
        //mutterList.add(0,mutter);
        MutterWDAO Wdao = new MutterWDAO();
        Wdao.create(mutterW);
    }
}
