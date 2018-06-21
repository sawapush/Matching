/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterMDAO;
import java.util.List;

/**
 *
 * @author g16934os
 */
public class GetMutterListLogicM {
    public List<MutterM> execute(){
        MutterMDAO Mdao = new MutterMDAO();
        List<MutterM> mutterListM = Mdao.findAll();
        return mutterListM;
    }
}
