/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MutterM;

/**
 *
 * @author g16934os
 */
public class MutterMDAO {
    private final String DRIVE_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/db3334";
    private final String DB_USER = "db3334";
    private final String DB_PASS = "db3334";

    public List<MutterM> findAll() {
        Connection conn = null;
        List<MutterM> mutterListM = new ArrayList<MutterM>();
        try {
            Class.forName(DRIVE_NAME);
            //String driverURL = "jdbc:derby://localhost:1527/docoTsubuDB";
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            //String sq1 = "SELECT ID, MNAME, MAGE, MINCOME FROM MAN ORDER BY ID DESC";
            String sq1 = "SELECT MNAME, MAGE, MINCOME FROM MAN";
            PreparedStatement pStmt = conn.prepareStatement(sq1);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                //int id = rs.getInt("ID");
                String MuserName = rs.getString("MNAME");
                String Mage = rs.getString("MAGE");
                String Mincome = rs.getString("MINCOME");
                MutterM mutterM = new MutterM(MuserName, Mage, Mincome);
                mutterListM.add(mutterM);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return mutterListM;
    }

   public boolean create(MutterM mutterM) {
        Connection conn = null;
        
        try {
            Class.forName(DRIVE_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            String sq1 = "INSERT INTO MAN(MNAME, MAGE, MINCOME) VALUES(?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sq1);
            
            pStmt.setString(1, mutterM.getMUserName());
            pStmt.setString(2, mutterM.getMAge());
            pStmt.setString(3, mutterM.getMIncome());

            int result = pStmt.executeUpdate();
            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            //return null;
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
