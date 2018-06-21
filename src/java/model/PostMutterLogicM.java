/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterMDAO;

/**
 *
 * @author g16934os
 */
public class PostMutterLogicM {
    public void execute(MutterM mutterM){
        //mutterList.add(0,mutter);
        MutterMDAO Mdao = new MutterMDAO();
        Mdao.create(mutterM);
    }
}
