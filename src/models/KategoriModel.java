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
public class KategoriModel{
    private static DBHelper dbHelper;
    private static final String tableName = "kategori";
    
    public static String kategoriId;
    public static String namaKategori;
    
    public KategoriModel(){
        dbHelper = new DBHelper();
    }

    public void setValue(String nama) {
        namaKategori = nama;
    }
    
    public void setUpdateValue(String nama, String id_kategori) {
        namaKategori = nama;
        kategoriId = id_kategori;
    }
    
    public boolean insertKategori() {        
        return dbHelper.Insert(tableName, "nama_kategori", "'"+namaKategori+"'");
    }
    
    public boolean updateKategori() {    
        String data = "nama_kategori = '" + namaKategori + "'";
        
        String whereCondition = "id_kategori = " + kategoriId;
        return dbHelper.Update(tableName, data, whereCondition);
    }
    
    public ResultSet loadData() {
        return dbHelper.GetData(tableName);
    }
    
    public ResultSet getKategoriById(String id_kategori) {
        return dbHelper.GetDataBy(tableName, "id_kategori", id_kategori);
    }
    
    public void deleteKategori(String id_kategori) {
        dbHelper.Delete(tableName, "id_kategori = " + id_kategori);
    }
}
