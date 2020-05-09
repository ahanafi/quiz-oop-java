/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;

/**
 *
 * @author Ahmad Hanafi
 */
public class UserModel {
    private static DBHelper dbHelper;
    private static String tableName = "users";
    
    public static String userId;
    public static String username;
    public static String password;
    public static String namaLengkap;
    public static String level;
    public static String telpon;
    
    public UserModel() {
        dbHelper = new DBHelper();
    }
    
    public void setValue(String uname, String pass, String nama, String tipe, String tel) {
        username = uname;
        password = pass;
        namaLengkap = nama;
        level = getLevel(tipe);
        telpon = tel;
    }
    
    public void setUpdateValue(String uname, String nama, String tipe, String tel, String id_user) {
        username = uname;
        namaLengkap = nama;
        level = getLevel(tipe);
        telpon = tel;
        userId = id_user;
    }
    
    public boolean insertUser() {
        String columns = "username, password, nama_lengkap, level, telpon";
        String values = "'" + username +"', ";
                values += "MD5('" + password +"'),";
                values += "'" + namaLengkap +"', ";
                values += "'" + level +"', ";
                values += "'" + telpon +"'";
        
        return dbHelper.Insert(tableName, columns, values);
    }
    
    public boolean updateUser() {    
        String data = "username = '" + username + "', ";
        data += "nama_lengkap= '" + namaLengkap + "', ";
        data += "telpon = '" + telpon + "', ";
        data += "level = '" + level + "'";
        
        String whereCondition = "id_user = " + userId;
        return dbHelper.Update(tableName, data, whereCondition);
    }
    
    public String getLevel(String kode) {
        String level = "";
        switch (kode) {
            case "Administrator":
                level = "A";
                break;
            case "Staff Perpustakaan":
                level = "ST";
                break;
            case "A":
                level = "Administrator";
                break;
            case "ST":
                level = "Staff Perpustakaan";
                break;
            default:
                break;
        }

        return level;
    }
    
    public ResultSet loadData() {
        return dbHelper.GetData(tableName);
    }
    
    public ResultSet getUserById(String userId) {
        return dbHelper.GetDataBy(tableName, "id_user", userId);
    }
    
    public void deleteUser(String userId) {
        dbHelper.Delete(tableName, "id_user = " + userId);
    }
}
