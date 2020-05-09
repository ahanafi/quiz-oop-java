/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import utils.CustomHelper;

/**
 *
 * @author Ahmad Hanafi
 */
public class Authentication {
    private static DBHelper dbHelper;
    private static CustomHelper helper;
    private static UserModel userModel;
    private static String tableName;
    private String selectedLevel;
    
    public Authentication() {
        dbHelper = new DBHelper();
        userModel = new UserModel();
        helper = new CustomHelper();
    }
    
    public void setLevel(String level) {
        this.selectedLevel = level;
    }
    
    public boolean doLogin(String user, String pass) {
        boolean isAuthenticated = false;
        if(! selectedLevel.equals("")) {
            try{
                String bindingWhere = "";
                if(selectedLevel.equals("Administrator") || selectedLevel.equals("Staff Perpustakaan")) {
                    tableName = "users";
                    String level = userModel.getLevel(selectedLevel);
                    bindingWhere = "username = '"+user+"' AND password = MD5('"+pass+"') AND level = '"+level+"'";
                } else if(selectedLevel.equals("Mahasiswa")) {
                    tableName = "mahasiswa";
                    bindingWhere = "nim = '"+user+"' AND password = MD5('"+pass+"')";
                }

                if(! bindingWhere.equals("")) {
                    ResultSet getUser = dbHelper.GetDataWhere(tableName, bindingWhere);
                    if(getUser.next()) {
                        isAuthenticated = true;
                    }
                }            
            } catch(SQLException e) {
                helper.showMessage(null, e.getMessage());
            }
        }
        return isAuthenticated;
    }
}
