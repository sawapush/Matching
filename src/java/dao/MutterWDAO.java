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
import model.MutterW;

/**
 *
 * @author g16934os
 */
public class MutterWDAO {
    private final String DRIVE_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/db3334";
    private final String DB_USER = "db3334";
    private final String DB_PASS = "db3334";

    public List<MutterW> findAll() {
        Connection conn = null;
        List<MutterW> mutterListW = new ArrayList<MutterW>();
        try {
            Class.forName(DRIVE_NAME);
            //String driverURL = "jdbc:derby://localhost:1527/docoTsubuDB";
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            //String sq1 = "SELECT MNAME, MAGE, MINCOME FROM MUTTERM ORDER BY MNAME DESC";
            String sq1 = "SELECT WNAME, WAGE, WINCOME FROM WOMAN";
            PreparedStatement pStmt = conn.prepareStatement(sq1);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String WuserName = rs.getString("WNAME");
                String Wage = rs.getString("WAGE");
                String Wincome = rs.getString("WINCOME");
                MutterW mutterW = new MutterW(WuserName, Wage, Wincome);
                mutterListW.add(mutterW);
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
        return mutterListW;
    }

   public boolean create(MutterW mutterW) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            String sq1 = "INSERT INTO WOMAN(WNAME, WAGE, WINCOME) VALUES(?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sq1);
            pStmt.setString(1, mutterW.getWUserName());
            pStmt.setString(2, mutterW.getWAge());
            pStmt.setString(3, mutterW.getWIncome());
            int result = pStmt.executeUpdate();
            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
