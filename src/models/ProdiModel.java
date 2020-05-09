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
public class ProdiModel {
    private static DBHelper dbHelper;
    private static final String tableName = "program_studi";
    
    public static String prodiId;
    public static String kodeProdi;
    public static String namaProdi;
    public static String jenjangProdi;
    
    public ProdiModel() {
        dbHelper = new DBHelper();
    }


    public void setValue(String nama, String kode, String jenjang) {
        namaProdi = nama;
        kodeProdi = kode;
        jenjangProdi = jenjang;
        
    }
    
    public void setUpdateValue(String nama, String jenjang, String kode_prodi) {
        namaProdi = nama;
        jenjangProdi = jenjang;
        kodeProdi = kode_prodi;
    }
    
    public boolean insertProdi() {
        String columns = "kode, nama, jenjang";
        String values = "'"+kodeProdi+"',";
        values += "'"+namaProdi+"',";
        values += "'"+jenjangProdi+"'";
        return dbHelper.Insert(tableName, columns, values);
    }
    
    public boolean updateProdi() {    
        String data = "nama = '" + namaProdi + "',";
        data += "jenjang = '"+jenjangProdi+"'";
        
        String whereCondition = "kode = '" + kodeProdi + "'";
        return dbHelper.Update(tableName, data, whereCondition);
    }
    
    public ResultSet loadData() {
        return dbHelper.GetData(tableName);
    }
    
    public ResultSet getProdiByCode(String kode) {
        return dbHelper.GetDataBy(tableName, "kode", kode);
    }
    
    public void deleteProdi(String kode_prodi) {
        dbHelper.Delete(tableName, "kode = '" + kode_prodi+ "'");
    }
    
    public String getAutoCode() {
        return dbHelper.generateCode(tableName, "kode", "PRO");
    }

    public ResultSet getProdiById(String idProdi) {
        return dbHelper.GetDataBy(tableName, "id_prodi", idProdi);
    }
}
