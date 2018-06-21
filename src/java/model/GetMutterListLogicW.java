/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterWDAO;
import java.util.List;

/**
 *
 * @author g16934os
 */
public class GetMutterListLogicW {
    public List<MutterW> execute(){
        MutterWDAO Wdao = new MutterWDAO();
        List<MutterW> mutterListW = Wdao.findAll();
        return mutterListW;
    }
}
