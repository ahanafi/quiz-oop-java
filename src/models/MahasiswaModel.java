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
public class MahasiswaModel {
    private static DBHelper dbHelper;
    private static String tableName = "mahasiswa";
    
    public static String mahasiswaId;
    public static String nim;
    public static String namaLengkap;
    public static String jenisKelamin;
    public static String telpon;
    public static String alamat;
    public static int prodiId;
    public static int semester;
    
    public MahasiswaModel() {
        dbHelper = new DBHelper();
    }
    
    public void setValue(String nimMhs, String nama, String jk, int smt, int id_prodi, String alamatMhs, String telp) {
        nim = nimMhs;
        namaLengkap = nama;
        jenisKelamin = jk;
        semester = smt;
        alamat = alamatMhs;
        prodiId = id_prodi;
        telpon = telp;
    }
    
    public void setUpdateValue(String nimMhs, String nama, String jk, int smt, int id_prodi, String alamatMhs, String telp, String id_mahasiswa) {
        nim = nimMhs;
        namaLengkap = nama;
        jenisKelamin = jk;
        semester = smt;
        alamat = alamatMhs;
        prodiId = id_prodi;
        telpon = telp;
        mahasiswaId = id_mahasiswa;
    }
    
    public boolean insertMahasiswa() {
        String columns = "nim, nama_lengkap, jk, telpon, alamat, id_prodi, semester, password";
        String values = "'" + nim +"', ";
                values += "'" + namaLengkap +"',";
                values += "'" + jenisKelamin +"',";
                values += "'" + telpon +"', ";
                values += "'" + alamat +"', ";
                values += "'" + prodiId +"',";
                values += "'" + semester +"', ";
                values += "MD5('" + nim +"')";
                
        
        return dbHelper.Insert(tableName, columns, values);
    }
    
    public boolean updateMahasiswa() {    
        String data = "nama = '" + namaLengkap + "', ";
        data += "jk = '" + jenisKelamin + "', ";
        data += "semester = '" + semester + "', ";
        data += "id_prodi = '" + prodiId + "', ";
        data += "alamat = '" + alamat + "', ";
        data += "telpon = '" + telpon + "'";
        
        String whereCondition = "nim = '" + nim + "'";
        return dbHelper.Update(tableName, data, whereCondition);
    }
    
    public ResultSet loadData() {
        return dbHelper.GetData(tableName);
    }
    
    public ResultSet getMahasiswaWithProdi() {
        String myQuery = "SELECT mahasiswa.*, program_studi.nama AS prodi FROM mahasiswa JOIN program_studi USING (id_prodi)";
        myQuery += " ORDER BY id_mahasiswa";
        return dbHelper.GetDataWithCutomQuery(myQuery);
    }
    
    public ResultSet getMahasiswaByNIM(String nim) {
        return dbHelper.GetDataBy(tableName, "nim", nim);
    }
    
    public void deleteMahasiswa(String nim) {
        dbHelper.Delete(tableName, "nim= '" + nim + "'");
    }
}
