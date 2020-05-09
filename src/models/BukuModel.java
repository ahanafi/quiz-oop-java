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
public class BukuModel {
    private static DBHelper dbHelper;
    private static String tableName = "buku";
    
    public static String bukuId;
    public static String kodeBuku;
    public static String judul;
    public static String isbn;
    public static int idKategori;
    public static String pengarang;
    public static String penerbit;
    public static String sinopsis;
    
    public BukuModel() {
        dbHelper = new DBHelper();
    }
    
    public void setValue(String kode, String judulBuku, String isbnBuku, int id_kategori, String namaPenerbit, String namaPengarang, String sinopsisBuku) {
        kodeBuku = kode;
        judul = judulBuku;
        isbn = isbnBuku;
        idKategori = id_kategori;
        pengarang = namaPengarang;
        penerbit = namaPenerbit;
        sinopsis = sinopsisBuku;
    }
    
    public void setUpdateValue(String judulBuku, String isbnBuku, int id_kategori, String namaPenerbit, String namaPengarang, String sinopsisBuku, String kode) {
        judul = judulBuku;
        isbn = isbnBuku;
        idKategori = id_kategori;
        pengarang = namaPengarang;
        penerbit = namaPenerbit;
        sinopsis = sinopsisBuku;
        kodeBuku = kode;
    }
    
    public boolean insertBuku() {
        String columns = "kode_buku, isbn, judul, id_kategori, penerbit, pengarang, sinopsis";
        String values = "'" + kodeBuku +"', ";
                values += "'" + isbn +"',";
                values += "'" + judul +"',";
                values += "'" + idKategori +"', ";
                values += "'" + penerbit +"',";
                values += "'" + pengarang +"', ";
                values += "'" + sinopsis +"'";
        
        return dbHelper.Insert(tableName, columns, values);
    }
    
    public boolean updateBuku() {    
        String data = "judul = '" + judul + "', ";
        data += "isbn = '" + isbn + "', ";
        data += "id_kategori = '" + idKategori + "', ";
        data += "penerbit = '" + penerbit + "', ";
        data += "pengarang = '" + pengarang + "', ";
        data += "sinopsis = '" + sinopsis + "'";
        
        String whereCondition = "kode_buku = '" + kodeBuku + "'";
        return dbHelper.Update(tableName, data, whereCondition);
    }
    
    public ResultSet loadData() {
        return dbHelper.GetData(tableName);
    }
    
    public ResultSet getBukuWithCategory() {
        String myQuery = "SELECT buku.*, kategori.nama_kategori AS kategori FROM buku JOIN kategori USING (id_kategori)";
        myQuery += " ORDER BY id_buku";
        return dbHelper.GetDataWithCutomQuery(myQuery);
    }
    
    public ResultSet getBukuByCode(String kodeBuku) {
        return dbHelper.GetDataBy(tableName, "kode_buku", kodeBuku);
    }
    
    public void deleteBuku(String kodeBuku) {
        dbHelper.Delete(tableName, "kode_buku = '" + kodeBuku + "'");
    }
    
    public String getAutoCode() {
        return dbHelper.generateCode(tableName, "kode_buku", "BK");
    }
}
