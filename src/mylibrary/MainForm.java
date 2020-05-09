/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary;

import utils.Item;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import models.*;
import utils.CustomHelper;

/**
 *
 * @author Ahmad Hanafi
 */
public class MainForm extends javax.swing.JFrame {
    /* Define All Models */
    private final UserModel userModel;
    private final KategoriModel kategoriModel;
    private final ProdiModel prodiModel;
    private final BukuModel bukuModel;
    private final MahasiswaModel mhsModel;
    
    private final CustomHelper helper;
    private final DefaultTableModel userTableModel, kategoriTableModel, prodiTableModel, bukuTableModel, mhsTableModel;
    
    private String selectedUserId, selectedKategoriId, selectedProdiCode, selectedKodeBuku, selectedNim;
    
    public static String userName, userLevel;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        int formWidth = dim.width/ 2 - this.getSize().width/2;
        int formHeight = dim.height/2-this.getSize().height/2;
        this.setLocation(formWidth, formHeight);
        this.setResizable(false);
        
        helper = new CustomHelper();
        
        /* USER SECTION */
        userModel = new UserModel();
        userTableModel = new DefaultTableModel();
        userTableModel.addColumn("ID");
        userTableModel.addColumn("Username");
        userTableModel.addColumn("Level");
        userTableModel.addColumn("Telpon");
        userDataTable.setModel(userTableModel);
        resetUserForm();
        loadUserData();
        
        /* KATEGORI SECTION */
        kategoriModel = new KategoriModel();
        kategoriTableModel = new DefaultTableModel();
        kategoriTableModel.addColumn("ID");
        kategoriTableModel.addColumn("Nama Kategori");
        kategoriDataTable.setModel(kategoriTableModel);
        resetKategoriForm();
        loadKategoriData();
        
        /* PRODI SECTION */
        prodiModel = new ProdiModel();
        prodiTableModel = new DefaultTableModel();
        prodiTableModel.addColumn("Kode Prodi");
        prodiTableModel.addColumn("Nama Prodi");
        prodiTableModel.addColumn("Jenjang");
        prodiDataTable.setModel(prodiTableModel);
        resetProdiForm();
        loadProdiData();
        
        /* BUKU SECTION */
        bukuModel = new BukuModel();
        bukuTableModel = new DefaultTableModel();
        bukuTableModel.addColumn("Kode Buku");
        bukuTableModel.addColumn("ISBN");
        bukuTableModel.addColumn("Judul");
        bukuTableModel.addColumn("Kategori");
        bukuTableModel.addColumn("Penerbit");
        bukuTableModel.addColumn("Pengarang");
        bukuDataTable.setModel(bukuTableModel);
        resetBukuForm();
        loadBukuData();
        
        /* MAHASISWA SECTION */
        mhsModel = new MahasiswaModel();
        mhsTableModel = new DefaultTableModel();
        mhsTableModel.addColumn("NIM");
        mhsTableModel.addColumn("Nama Lengkap");
        mhsTableModel.addColumn("JK");
        mhsTableModel.addColumn("Program Studi");
        mhsTableModel.addColumn("Semester");
        mhsTableModel.addColumn("Telpon");
        mhsDataTable.setModel(mhsTableModel);
        resetMahasiswaForm();
        loadMahasiswaData();

        showContent(homePanel);
    }
    
    public void setUserLoggedIn(String uname, String ulevel) {
        userName = uname;
        userLevel = ulevel;
        
        String currentStatus = userLoggedInStatus.getText();
        String newStatus = currentStatus + " : " + userName + " ("+userLevel+")";
        userLoggedInStatus.setText(newStatus);
        
        if(userLevel.equals("Staff Perpustakaan")) {
            manajemenPengguna.setVisible(false);
            
            //Hidden Form
            prodiFormPanel.setVisible(false);
            mahasiswaFormPanel.setVisible(false);
            
            //Hiden delete button
            btnDeleteBuku.setVisible(false);
            btnDeleteKategori.setVisible(false);
            btnDeleteMhs.setVisible(false);
            btnDeleteProdi.setVisible(false);
        }
        
        if(userLevel.equals("Mahasiswa")) {
            manajemenPengguna.setVisible(false);
            dataProgramStudi.setVisible(false);
            
            //Hidden Form
            kategoriFormPanel.setVisible(false);
            bukuFormPanel.setVisible(false);
            mahasiswaFormPanel.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        appName = new javax.swing.JLabel();
        userLoggedInStatus = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        userFormPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        namaLengkapText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        telponText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboHakAkses = new javax.swing.JComboBox<>();
        btnResetUser = new javax.swing.JButton();
        btnSaveUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnUpdateUser = new javax.swing.JButton();
        userDataPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        userDataTable = new javax.swing.JTable();
        bukuPanel = new javax.swing.JPanel();
        bukuFormPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kodeBukuText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pengarangText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        penerbitText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboKategori = new javax.swing.JComboBox<>();
        btnResetBuku = new javax.swing.JButton();
        btnSaveBuku = new javax.swing.JButton();
        btnDeleteBuku = new javax.swing.JButton();
        btnUpdateBuku = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        sinopsisText = new javax.swing.JTextArea();
        isbnText = new javax.swing.JTextField();
        judulText = new javax.swing.JTextField();
        bukuDataPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bukuDataTable = new javax.swing.JTable();
        kategoriPanel = new javax.swing.JPanel();
        kategoriFormPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnSaveKategori = new javax.swing.JButton();
        btnResetKategori = new javax.swing.JButton();
        btnUpdateKategori = new javax.swing.JButton();
        btnDeleteKategori = new javax.swing.JButton();
        namaKategoriText = new javax.swing.JTextField();
        kategoriDataPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kategoriDataTable = new javax.swing.JTable();
        prodiPanel = new javax.swing.JPanel();
        prodiFormPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        kodeProdiText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        namaProdiText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        comboJenjang = new javax.swing.JComboBox<>();
        btnResetProdi = new javax.swing.JButton();
        btnSaveProdi = new javax.swing.JButton();
        btnDeleteProdi = new javax.swing.JButton();
        btnUpdateProdi = new javax.swing.JButton();
        prodiDataPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        prodiDataTable = new javax.swing.JTable();
        mahasiswaPanel = new javax.swing.JPanel();
        mahasiswaFormPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        nimText = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        telponMhsText = new javax.swing.JTextField();
        comboJK = new javax.swing.JComboBox<>();
        btnResetMhs = new javax.swing.JButton();
        btnSaveMhs = new javax.swing.JButton();
        btnDeleteMhs = new javax.swing.JButton();
        btnUpdateMhs = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        namaMhsText = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        alamatText = new javax.swing.JTextField();
        comboProdi = new javax.swing.JComboBox<>();
        comboSemester = new javax.swing.JComboBox<>();
        mahasiswaDataPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        mhsDataTable = new javax.swing.JTable();
        myMenuBar = new javax.swing.JMenuBar();
        home = new javax.swing.JMenu();
        dataMaster = new javax.swing.JMenu();
        dataBuku = new javax.swing.JMenuItem();
        kategoriBuku = new javax.swing.JMenuItem();
        dataMahasiswa = new javax.swing.JMenuItem();
        dataProgramStudi = new javax.swing.JMenuItem();
        manajemenPengguna = new javax.swing.JMenu();
        keluar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        mainPanel.setMaximumSize(new java.awt.Dimension(1366, 768));
        mainPanel.setMinimumSize(new java.awt.Dimension(1366, 768));
        mainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        homePanel.setBackground(new java.awt.Color(51, 153, 255));
        homePanel.setEnabled(false);
        homePanel.setMaximumSize(new java.awt.Dimension(1360, 760));
        homePanel.setPreferredSize(new java.awt.Dimension(1366, 760));

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        welcomeLabel.setText("Welcome to the ");
        welcomeLabel.setInheritsPopupMenu(false);

        appName.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        appName.setText("Java Simple Library App");
        appName.setInheritsPopupMenu(false);

        userLoggedInStatus.setBackground(new java.awt.Color(255, 204, 0));
        userLoggedInStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userLoggedInStatus.setText("Anda login Sebagai");
        userLoggedInStatus.setInheritsPopupMenu(false);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(469, 469, 469)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addGap(138, 138, 138))
                    .addComponent(appName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userLoggedInStatus))
                .addContainerGap(490, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(welcomeLabel)
                .addGap(18, 18, 18)
                .addComponent(appName)
                .addGap(30, 30, 30)
                .addComponent(userLoggedInStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userPanel.setBackground(new java.awt.Color(0, 255, 102));
        userPanel.setEnabled(false);
        userPanel.setMaximumSize(new java.awt.Dimension(1360, 760));
        userPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        userFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM TAMBAH/EDIT PENGGUNA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        userFormPanel.setName(""); // NOI18N
        userFormPanel.setPreferredSize(new java.awt.Dimension(465, 760));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Username");

        usernameText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Password");

        passwordText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Nama Lengkap");

        namaLengkapText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Telpon");

        telponText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setText("Hak Akses");

        comboHakAkses.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        comboHakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Staff Perpustakaan" }));

        btnResetUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnResetUser.setText("RESET");
        btnResetUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetUserActionPerformed(evt);
            }
        });

        btnSaveUser.setBackground(new java.awt.Color(51, 153, 255));
        btnSaveUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSaveUser.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveUser.setText("SIMPAN");
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setText("DELETE");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnUpdateUser.setBackground(new java.awt.Color(51, 255, 51));
        btnUpdateUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdateUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateUser.setText("UPDATE");
        btnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userFormPanelLayout = new javax.swing.GroupLayout(userFormPanel);
        userFormPanel.setLayout(userFormPanelLayout);
        userFormPanelLayout.setHorizontalGroup(
            userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameText)
                    .addComponent(passwordText)
                    .addComponent(namaLengkapText)
                    .addComponent(telponText)
                    .addComponent(comboHakAkses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResetUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(userFormPanelLayout.createSequentialGroup()
                        .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userFormPanelLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        userFormPanelLayout.setVerticalGroup(
            userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaLengkapText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telponText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboHakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResetUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA PENGGUNA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        userDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userDataTable.setRowHeight(20);
        userDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userDataTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(userDataTable);

        javax.swing.GroupLayout userDataPanelLayout = new javax.swing.GroupLayout(userDataPanel);
        userDataPanel.setLayout(userDataPanelLayout);
        userDataPanelLayout.setHorizontalGroup(
            userDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        userDataPanelLayout.setVerticalGroup(
            userDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(userDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 655, Short.MAX_VALUE)
                    .addComponent(userFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        bukuPanel.setBackground(new java.awt.Color(0, 255, 102));
        bukuPanel.setEnabled(false);
        bukuPanel.setMaximumSize(new java.awt.Dimension(1360, 760));
        bukuPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        bukuFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM TAMBAH/EDIT BUKU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        bukuFormPanel.setName(""); // NOI18N
        bukuFormPanel.setPreferredSize(new java.awt.Dimension(465, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Kode Buku");

        kodeBukuText.setEditable(false);
        kodeBukuText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Pengarang");

        pengarangText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Penerbit");

        penerbitText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Sinopsis");

        comboKategori.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        comboKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Kategori Buku --" }));

        btnResetBuku.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnResetBuku.setText("RESET");
        btnResetBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetBukuActionPerformed(evt);
            }
        });

        btnSaveBuku.setBackground(new java.awt.Color(51, 153, 255));
        btnSaveBuku.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSaveBuku.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveBuku.setText("SIMPAN");
        btnSaveBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBukuActionPerformed(evt);
            }
        });

        btnDeleteBuku.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteBuku.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDeleteBuku.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBuku.setText("DELETE");
        btnDeleteBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBukuActionPerformed(evt);
            }
        });

        btnUpdateBuku.setBackground(new java.awt.Color(51, 255, 51));
        btnUpdateBuku.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdateBuku.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBuku.setText("UPDATE");
        btnUpdateBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBukuActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setText("ISBN");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("Kategori Buku");

        sinopsisText.setColumns(20);
        sinopsisText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sinopsisText.setRows(5);
        jScrollPane5.setViewportView(sinopsisText);

        isbnText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        judulText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout bukuFormPanelLayout = new javax.swing.GroupLayout(bukuFormPanel);
        bukuFormPanel.setLayout(bukuFormPanelLayout);
        bukuFormPanelLayout.setHorizontalGroup(
            bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(pengarangText)
                    .addComponent(penerbitText)
                    .addComponent(comboKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bukuFormPanelLayout.createSequentialGroup()
                        .addGroup(bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kodeBukuText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(28, 28, 28)
                        .addGroup(bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bukuFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(isbnText)))
                    .addComponent(judulText)
                    .addComponent(jLabel16)
                    .addGroup(bukuFormPanelLayout.createSequentialGroup()
                        .addComponent(btnSaveBuku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateBuku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteBuku)))
                .addContainerGap())
        );
        bukuFormPanelLayout.setVerticalGroup(
            bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeBukuText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbnText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judulText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengarangText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(penerbitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bukuFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResetBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnSaveBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );

        bukuDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA BUKU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        bukuDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bukuDataTable.setRowHeight(20);
        bukuDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bukuDataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bukuDataTable);

        javax.swing.GroupLayout bukuDataPanelLayout = new javax.swing.GroupLayout(bukuDataPanel);
        bukuDataPanel.setLayout(bukuDataPanelLayout);
        bukuDataPanelLayout.setHorizontalGroup(
            bukuDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bukuDataPanelLayout.setVerticalGroup(
            bukuDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout bukuPanelLayout = new javax.swing.GroupLayout(bukuPanel);
        bukuPanel.setLayout(bukuPanelLayout);
        bukuPanelLayout.setHorizontalGroup(
            bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bukuFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bukuDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        bukuPanelLayout.setVerticalGroup(
            bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bukuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bukuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bukuFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bukuDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kategoriPanel.setBackground(new java.awt.Color(255, 153, 51));
        kategoriPanel.setMaximumSize(new java.awt.Dimension(1366, 760));
        kategoriPanel.setMinimumSize(new java.awt.Dimension(1366, 760));
        kategoriPanel.setPreferredSize(new java.awt.Dimension(1366, 760));

        kategoriFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM TAMBAH / EDIT KATEGORI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Nama Kategori");

        btnSaveKategori.setBackground(new java.awt.Color(51, 153, 255));
        btnSaveKategori.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSaveKategori.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveKategori.setText("SIMPAN");
        btnSaveKategori.setPreferredSize(new java.awt.Dimension(100, 35));
        btnSaveKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveKategoriActionPerformed(evt);
            }
        });

        btnResetKategori.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnResetKategori.setText("RESET");
        btnResetKategori.setPreferredSize(new java.awt.Dimension(100, 35));
        btnResetKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetKategoriActionPerformed(evt);
            }
        });

        btnUpdateKategori.setBackground(new java.awt.Color(51, 255, 51));
        btnUpdateKategori.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdateKategori.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateKategori.setText("UPDATE");
        btnUpdateKategori.setPreferredSize(new java.awt.Dimension(100, 35));
        btnUpdateKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKategoriActionPerformed(evt);
            }
        });

        btnDeleteKategori.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteKategori.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDeleteKategori.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteKategori.setText("DELETE");
        btnDeleteKategori.setPreferredSize(new java.awt.Dimension(100, 35));
        btnDeleteKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKategoriActionPerformed(evt);
            }
        });

        namaKategoriText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        namaKategoriText.setMaximumSize(new java.awt.Dimension(100, 35));

        javax.swing.GroupLayout kategoriFormPanelLayout = new javax.swing.GroupLayout(kategoriFormPanel);
        kategoriFormPanel.setLayout(kategoriFormPanelLayout);
        kategoriFormPanelLayout.setHorizontalGroup(
            kategoriFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategoriFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kategoriFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kategoriFormPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kategoriFormPanelLayout.createSequentialGroup()
                        .addComponent(namaKategoriText, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kategoriFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnResetKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(btnSaveKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(kategoriFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdateKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        kategoriFormPanelLayout.setVerticalGroup(
            kategoriFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategoriFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kategoriFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaKategoriText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kategoriFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        kategoriDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA KATEGORI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        kategoriDataTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kategoriDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        kategoriDataTable.setRowHeight(20);
        kategoriDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kategoriDataTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(kategoriDataTable);

        javax.swing.GroupLayout kategoriDataPanelLayout = new javax.swing.GroupLayout(kategoriDataPanel);
        kategoriDataPanel.setLayout(kategoriDataPanelLayout);
        kategoriDataPanelLayout.setHorizontalGroup(
            kategoriDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategoriDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        kategoriDataPanelLayout.setVerticalGroup(
            kategoriDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategoriDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout kategoriPanelLayout = new javax.swing.GroupLayout(kategoriPanel);
        kategoriPanel.setLayout(kategoriPanelLayout);
        kategoriPanelLayout.setHorizontalGroup(
            kategoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategoriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kategoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kategoriFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kategoriDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kategoriPanelLayout.setVerticalGroup(
            kategoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategoriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kategoriFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kategoriDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        prodiPanel.setBackground(new java.awt.Color(255, 0, 51));
        prodiPanel.setMaximumSize(new java.awt.Dimension(1366, 768));
        prodiPanel.setMinimumSize(new java.awt.Dimension(1366, 768));
        prodiPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        prodiFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM TAMBAH/EDIT PROGRAM STUDI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        prodiFormPanel.setMaximumSize(new java.awt.Dimension(465, 600));
        prodiFormPanel.setMinimumSize(new java.awt.Dimension(465, 600));
        prodiFormPanel.setName(""); // NOI18N
        prodiFormPanel.setPreferredSize(new java.awt.Dimension(465, 600));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Kode Prodi");

        kodeProdiText.setEditable(false);
        kodeProdiText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Nama Program Studi");

        namaProdiText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("Jenjang");

        comboJenjang.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        comboJenjang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D1", "D2", "D3", "D4", "S1", "S2", "S3" }));

        btnResetProdi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnResetProdi.setText("RESET");
        btnResetProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetProdiActionPerformed(evt);
            }
        });

        btnSaveProdi.setBackground(new java.awt.Color(51, 153, 255));
        btnSaveProdi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSaveProdi.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProdi.setText("SIMPAN");
        btnSaveProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProdiActionPerformed(evt);
            }
        });

        btnDeleteProdi.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteProdi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDeleteProdi.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProdi.setText("DELETE");
        btnDeleteProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProdiActionPerformed(evt);
            }
        });

        btnUpdateProdi.setBackground(new java.awt.Color(51, 255, 51));
        btnUpdateProdi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdateProdi.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateProdi.setText("UPDATE");
        btnUpdateProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProdiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout prodiFormPanelLayout = new javax.swing.GroupLayout(prodiFormPanel);
        prodiFormPanel.setLayout(prodiFormPanelLayout);
        prodiFormPanelLayout.setHorizontalGroup(
            prodiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodiFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prodiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodeProdiText)
                    .addComponent(btnSaveProdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResetProdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaProdiText)
                    .addComponent(comboJenjang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(prodiFormPanelLayout.createSequentialGroup()
                        .addGroup(prodiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(prodiFormPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdateProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteProdi, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        prodiFormPanelLayout.setVerticalGroup(
            prodiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodiFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kodeProdiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaProdiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboJenjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResetProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(prodiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        prodiDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA PROGRAM STUDI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        prodiDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        prodiDataTable.setRowHeight(20);
        prodiDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodiDataTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(prodiDataTable);

        javax.swing.GroupLayout prodiDataPanelLayout = new javax.swing.GroupLayout(prodiDataPanel);
        prodiDataPanel.setLayout(prodiDataPanelLayout);
        prodiDataPanelLayout.setHorizontalGroup(
            prodiDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodiDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        prodiDataPanelLayout.setVerticalGroup(
            prodiDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodiDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout prodiPanelLayout = new javax.swing.GroupLayout(prodiPanel);
        prodiPanel.setLayout(prodiPanelLayout);
        prodiPanelLayout.setHorizontalGroup(
            prodiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prodiFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prodiDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        prodiPanelLayout.setVerticalGroup(
            prodiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prodiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prodiFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodiDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(3043, Short.MAX_VALUE))
        );

        mahasiswaPanel.setBackground(new java.awt.Color(0, 255, 102));
        mahasiswaPanel.setEnabled(false);
        mahasiswaPanel.setMaximumSize(new java.awt.Dimension(1360, 760));
        mahasiswaPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        mahasiswaFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM TAMBAH/EDIT MAHASISWA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        mahasiswaFormPanel.setName(""); // NOI18N
        mahasiswaFormPanel.setPreferredSize(new java.awt.Dimension(465, 700));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel17.setText("NIM");

        nimText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel18.setText("Nama Lengkap");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel19.setText("Jenis Kelamin");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel20.setText("Telpon");

        telponMhsText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        comboJK.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        comboJK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Kelamin --", "Laki-Laki", "Perempuan" }));

        btnResetMhs.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnResetMhs.setText("RESET");
        btnResetMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetMhsActionPerformed(evt);
            }
        });

        btnSaveMhs.setBackground(new java.awt.Color(51, 153, 255));
        btnSaveMhs.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSaveMhs.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveMhs.setText("SIMPAN");
        btnSaveMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMhsActionPerformed(evt);
            }
        });

        btnDeleteMhs.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteMhs.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDeleteMhs.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMhs.setText("DELETE");
        btnDeleteMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMhsActionPerformed(evt);
            }
        });

        btnUpdateMhs.setBackground(new java.awt.Color(51, 255, 51));
        btnUpdateMhs.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdateMhs.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateMhs.setText("UPDATE");
        btnUpdateMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMhsActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel22.setText("Semester");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel23.setText("Program Studi");

        namaMhsText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel24.setText("Alamat");

        alamatText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        comboProdi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        comboProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Kategori Buku --" }));

        comboSemester.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        comboSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Semester --" }));

        javax.swing.GroupLayout mahasiswaFormPanelLayout = new javax.swing.GroupLayout(mahasiswaFormPanel);
        mahasiswaFormPanel.setLayout(mahasiswaFormPanelLayout);
        mahasiswaFormPanelLayout.setHorizontalGroup(
            mahasiswaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahasiswaFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mahasiswaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telponMhsText)
                    .addComponent(namaMhsText)
                    .addComponent(nimText)
                    .addComponent(comboJK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alamatText)
                    .addGroup(mahasiswaFormPanelLayout.createSequentialGroup()
                        .addGroup(mahasiswaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mahasiswaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel23)
                            .addGroup(mahasiswaFormPanelLayout.createSequentialGroup()
                                .addComponent(btnSaveMhs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResetMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateMhs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteMhs))
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboProdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboSemester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mahasiswaFormPanelLayout.setVerticalGroup(
            mahasiswaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahasiswaFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nimText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaMhsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboJK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telponMhsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alamatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mahasiswaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResetMhs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveMhs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteMhs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        mahasiswaDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA MAHASISWA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        mhsDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        mhsDataTable.setRowHeight(20);
        mhsDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mhsDataTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(mhsDataTable);

        javax.swing.GroupLayout mahasiswaDataPanelLayout = new javax.swing.GroupLayout(mahasiswaDataPanel);
        mahasiswaDataPanel.setLayout(mahasiswaDataPanelLayout);
        mahasiswaDataPanelLayout.setHorizontalGroup(
            mahasiswaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahasiswaDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mahasiswaDataPanelLayout.setVerticalGroup(
            mahasiswaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahasiswaDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        javax.swing.GroupLayout mahasiswaPanelLayout = new javax.swing.GroupLayout(mahasiswaPanel);
        mahasiswaPanel.setLayout(mahasiswaPanelLayout);
        mahasiswaPanelLayout.setHorizontalGroup(
            mahasiswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahasiswaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mahasiswaFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mahasiswaDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        mahasiswaPanelLayout.setVerticalGroup(
            mahasiswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahasiswaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mahasiswaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mahasiswaFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addComponent(mahasiswaDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prodiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addComponent(bukuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addComponent(mahasiswaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1392, Short.MAX_VALUE)
                            .addGap(1332, 1332, 1332)))))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(kategoriPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 2712, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 3565, Short.MAX_VALUE)
                    .addComponent(prodiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 3565, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bukuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mahasiswaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 699, Short.MAX_VALUE)
                    .addGap(2173, 2173, 2173))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(398, Short.MAX_VALUE)
                    .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 2516, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(kategoriPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 3565, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        myMenuBar.add(home);

        dataMaster.setText("Data Master");

        dataBuku.setText("Data Buku");
        dataBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataBukuActionPerformed(evt);
            }
        });
        dataMaster.add(dataBuku);

        kategoriBuku.setText("Kategori Buku");
        kategoriBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriBukuActionPerformed(evt);
            }
        });
        dataMaster.add(kategoriBuku);

        dataMahasiswa.setText("Data Mahasiswa");
        dataMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataMahasiswaActionPerformed(evt);
            }
        });
        dataMaster.add(dataMahasiswa);

        dataProgramStudi.setText("Data Program Studi");
        dataProgramStudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataProgramStudiActionPerformed(evt);
            }
        });
        dataMaster.add(dataProgramStudi);

        myMenuBar.add(dataMaster);

        manajemenPengguna.setText("Manajemen Pengguna");
        manajemenPengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manajemenPenggunaMouseClicked(evt);
            }
        });
        myMenuBar.add(manajemenPengguna);

        keluar.setText("Keluar");
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
        });
        myMenuBar.add(keluar);

        setJMenuBar(myMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /* MENU EVENT */
    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        showContent(homePanel);
    }//GEN-LAST:event_homeMouseClicked

    private void manajemenPenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manajemenPenggunaMouseClicked
        showContent(userPanel);
    }//GEN-LAST:event_manajemenPenggunaMouseClicked

    private void dataProgramStudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataProgramStudiActionPerformed
        showContent(prodiPanel);
    }//GEN-LAST:event_dataProgramStudiActionPerformed

    private void kategoriBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriBukuActionPerformed
        showContent(kategoriPanel);
    }//GEN-LAST:event_kategoriBukuActionPerformed

    private void dataMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataMahasiswaActionPerformed
        showContent(mahasiswaPanel);
    }//GEN-LAST:event_dataMahasiswaActionPerformed

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        int confirmExit = helper.confirmDialog(mainPanel, "Anda yakin akan keluar?", "Konfirmasi Keluar");
        if(confirmExit == 0) {
            this.setVisible(false);
            this.setEnabled(false);
            new FormLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_keluarMouseClicked

    /*
     *   USER SECTION
     */
    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        String username = usernameText.getText();
        String password = passwordText.getText();
        String nama = namaLengkapText.getText();
        String level = comboHakAkses.getSelectedItem().toString();
        String tel = telponText.getText();
        
        if(username.equals("") || password.equals("") || nama.equals("") || level.equals("") || tel.equals("")) {
            helper.showMessage(userPanel, "Semua form harus diisi!");
        } else {
            userModel.setValue(username, password, nama, level, tel);
            userModel.insertUser();
            helper.showMessage(userPanel, "Data pengguna baru berhasil disimpan!");
            resetUserForm();
            loadUserData();
        }
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void btnResetUserActionPerformed(java.awt.event.ActionEvent evt) {                                             
        resetUserForm();
    }

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if(! selectedUserId.equals("")) {
            int confirmDialog = helper.confirmDialog(this, "Anda yakin akan menghapus data ini?", "Konfirmasi Hapus data");
            if(confirmDialog == 0){
                userModel.deleteUser(selectedUserId);
                helper.showMessage(this, "Data user berhasil dihapus!");
                
                resetUserForm();
                loadUserData();
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed
        if(! selectedUserId.equals("")) {
            String username = usernameText.getText();
            String nama = namaLengkapText.getText();
            String level = comboHakAkses.getSelectedItem().toString();
            String tel = telponText.getText();

            if(username.equals("") || nama.equals("") || level.equals("") || tel.equals("")) {
                helper.showMessage(bukuPanel, "Semua form harus diisi!");
            } else {
                userModel.setUpdateValue(username, nama, level, tel, selectedUserId);
                userModel.updateUser();
                helper.showMessage(bukuPanel, "Data pengguna baru berhasil diperbarui!");
                resetUserForm();
                loadUserData();
            }
        }
    }//GEN-LAST:event_btnUpdateUserActionPerformed

    private void userDataTableMouseClicked(java.awt.event.MouseEvent evt) {                                           
        int row = userDataTable.getSelectedRow();
        if(row >= 0) {
            String userId = (userDataTable.getModel().getValueAt(row, 0).toString());
            if(! userId.equals("")) {
                try {
                    ResultSet userData = userModel.getUserById(userId);
                    if(userData.next()) {
                        String uname = userData.getString("username");
                        String namaLengkap = userData.getString("nama_lengkap");
                        String telpon = userData.getString("telpon");
                        String level = userModel.getLevel(userData.getString("level"));
                        
                        selectedUserId = userData.getString("id_user");
                        usernameText.setText(uname);
                        namaLengkapText.setText(namaLengkap);
                        telponText.setText(telpon);
                        comboHakAkses.setSelectedItem(level);

                        passwordText.setEnabled(false);
                        btnSaveUser.setEnabled(false);
                        btnDeleteUser.setEnabled(true);
                        btnUpdateUser.setEnabled(true);
                    }
                } catch (SQLException e) {
                    helper.showMessage(this, e.getMessage());
                }
            }   
        }
    }                                          

    private void loadUserData() {
        userTableModel.getDataVector().removeAllElements();
        userTableModel.fireTableDataChanged();
        try {
             ResultSet userData = userModel.loadData();
            while(userData.next()) {
            Object[] dataObject = new Object[5];
                dataObject[0] = userData.getString("id_user");
                dataObject[1] = userData.getString("username");
                dataObject[2] = userData.getString("nama_lengkap");
                dataObject[3] = userData.getString("level");
                dataObject[4] = userData.getString("telpon");
                
                userTableModel.addRow(dataObject); 
            }
        } catch (SQLException e) {
            helper.showMessage(this, e.getMessage());
        }
    }
    
    private void resetUserForm() {
        usernameText.setText("");
        passwordText.setText("");
        passwordText.setEnabled(true);
        telponText.setText("");
        namaLengkapText.setText("");
        comboHakAkses.removeAllItems();
        comboHakAkses.addItem("Administrator");
        comboHakAkses.addItem("Staff Perpustakaan");
        
        //Btn
        btnSaveUser.setEnabled(true);
        btnDeleteUser.setEnabled(false);
        btnUpdateUser.setEnabled(false);
        selectedUserId = "";
    }
    
    /*
     *   KATEGORI SECTION
     */
    private void btnDeleteKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKategoriActionPerformed
        if(! selectedKategoriId.equals("")) {
            int confirmDialog = helper.confirmDialog(this, "Anda yakin akan menghapus data ini?", "Konfirmasi Hapus data");
            if(confirmDialog == 0){
                kategoriModel.deleteKategori(selectedKategoriId);
                helper.showMessage(this, "Data kategori berhasil dihapus!");
                
                resetKategoriForm();
                loadKategoriData();
            }
        }
    }//GEN-LAST:event_btnDeleteKategoriActionPerformed

    private void btnUpdateKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKategoriActionPerformed
        if(! selectedKategoriId.equals("")) {
            String namaKategori = namaKategoriText.getText();
        
            if(namaKategori.equals("")) {
                helper.showMessage(kategoriPanel, "Nama kategori harus diisi!");
            } else {
                kategoriModel.setUpdateValue(namaKategori, selectedKategoriId );
                kategoriModel.updateKategori();
                helper.showMessage(kategoriPanel, "Data kategori berhasil disimpan!");
                resetKategoriForm();
                loadKategoriData();
            }
        }
    }//GEN-LAST:event_btnUpdateKategoriActionPerformed

    private void btnResetKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetKategoriActionPerformed
        resetKategoriForm();
    }//GEN-LAST:event_btnResetKategoriActionPerformed

    private void btnSaveKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveKategoriActionPerformed
        String namaKategori = namaKategoriText.getText();
        
        if(namaKategori.equals("")) {
            helper.showMessage(kategoriPanel, "Nama kategori harus diisi!");
        } else {
            kategoriModel.setValue(namaKategori);
            kategoriModel.insertKategori();
            helper.showMessage(kategoriPanel, "Data kategori baru berhasil disimpan!");
            resetKategoriForm();
            loadKategoriData();
        }
    }//GEN-LAST:event_btnSaveKategoriActionPerformed

    private void kategoriDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kategoriDataTableMouseClicked
        int row = kategoriDataTable.getSelectedRow();
        if(row >= 0) {
            String kategoriId = (kategoriDataTable.getModel().getValueAt(row, 0).toString());
            if(! kategoriId.equals("")) {
                try {
                    ResultSet kategoriData = kategoriModel.getKategoriById(kategoriId);
                    if(kategoriData.next()) {
                        String namaKategori = kategoriData.getString("nama_kategori");
                        
                        selectedKategoriId = kategoriData.getString("id_kategori");
                        namaKategoriText.setText(namaKategori);
                        
                        btnSaveKategori.setEnabled(false);
                        btnDeleteKategori.setEnabled(true);
                        btnUpdateKategori.setEnabled(true);
                    }
                } catch (SQLException e) {
                    helper.showMessage(this, e.getMessage());
                }
            }   
        }
    }//GEN-LAST:event_kategoriDataTableMouseClicked

    private void loadKategoriData() {
        kategoriTableModel.getDataVector().removeAllElements();
        kategoriTableModel.fireTableDataChanged();
        try {
            ResultSet kategoriData = kategoriModel.loadData();
            while(kategoriData.next()) {
                Object[] dataObject = new Object[2];
                dataObject[0] = kategoriData.getString("id_kategori");
                dataObject[1] = kategoriData.getString("nama_kategori");
                
                kategoriTableModel.addRow(dataObject); 
            }
        } catch (SQLException e) {
            helper.showMessage(this, e.getMessage());
        }
    }

    private void resetKategoriForm() {
        namaKategoriText.setText("");
        
        //Btn
        btnSaveKategori.setEnabled(true);
        btnDeleteKategori.setEnabled(false);
        btnUpdateKategori.setEnabled(false);
        selectedKategoriId = "";
    }
    
    
    /*
     *   PROGRAM STUDI SECTION
     */
    private void prodiDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodiDataTableMouseClicked
        int row = prodiDataTable.getSelectedRow();
        if(row >= 0) {
            String kodeProdi = (prodiDataTable.getModel().getValueAt(row, 0).toString());
            if(! kodeProdi.equals("")) {
                try {
                    ResultSet prodiData = prodiModel.getProdiByCode(kodeProdi);
                    if(prodiData.next()) {
                        String namaProdi = prodiData.getString("nama");
                        String jenjang   = prodiData.getString("jenjang");

                        selectedProdiCode = kodeProdi;

                        namaProdiText.setText(namaProdi);
                        kodeProdiText.setText(kodeProdi);
                        comboJenjang.setSelectedItem(jenjang);

                        btnSaveProdi.setEnabled(false);
                        btnDeleteProdi.setEnabled(true);
                        btnUpdateProdi.setEnabled(true);
                    }
                } catch (SQLException e) {
                    helper.showMessage(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_prodiDataTableMouseClicked

    private void btnUpdateProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProdiActionPerformed
        if(! selectedProdiCode.equals("")){
            String namaProdi = namaProdiText.getText();
            String kodePorid = kodeProdiText.getText();
            String jenjang = comboJenjang.getSelectedItem().toString();

            if(namaProdi.equals("") || kodePorid.equals("") || jenjang.equals("")) {
                helper.showMessage(prodiPanel, "Semua inputan harus diisi!");
            } else {
                prodiModel.setUpdateValue(namaProdi, jenjang, kodePorid);
                prodiModel.updateProdi();
                helper.showMessage(prodiPanel, "Data kategori berhasil disimpan!");
                resetProdiForm();
                loadProdiData();
            }
        }
    }//GEN-LAST:event_btnUpdateProdiActionPerformed

    private void btnDeleteProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProdiActionPerformed
        if(! selectedProdiCode.equals("")) {
            int confirmDialog = helper.confirmDialog(this, "Anda yakin akan menghapus data ini?", "Konfirmasi Hapus data");
            if(confirmDialog == 0){
                prodiModel.deleteProdi(selectedProdiCode);
                helper.showMessage(this, "Data program studi berhasil dihapus!");

                resetProdiForm();
                loadProdiData();
            }
        }
    }//GEN-LAST:event_btnDeleteProdiActionPerformed

    private void btnSaveProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProdiActionPerformed
        String namaProdi = namaProdiText.getText();
        String kodePorid = kodeProdiText.getText();
        String jenjang = comboJenjang.getSelectedItem().toString();

        if(namaProdi.equals("") || kodePorid.equals("") || jenjang.equals("")) {
            helper.showMessage(prodiPanel, "Semua inputan harus diisi!");
        } else {
            prodiModel.setValue(namaProdi, kodePorid, jenjang);
            prodiModel.insertProdi();
            helper.showMessage(prodiPanel, "Data kategori baru berhasil disimpan!");
            resetProdiForm();
            loadProdiData();
        }
    }//GEN-LAST:event_btnSaveProdiActionPerformed

    private void btnResetProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetProdiActionPerformed
        resetProdiForm();
    }//GEN-LAST:event_btnResetProdiActionPerformed

    private void loadProdiData() {
        prodiTableModel.getDataVector().removeAllElements();
        prodiTableModel.fireTableDataChanged();
        try {
             ResultSet prodiData = prodiModel.loadData();
            while(prodiData.next()) {
            Object[] dataObject = new Object[3];
                dataObject[0] = prodiData.getString("kode");
                dataObject[1] = prodiData.getString("nama");
                dataObject[2] = prodiData.getString("jenjang");                
                
                prodiTableModel.addRow(dataObject); 
            }
        } catch (SQLException e) {
            helper.showMessage(this, e.getMessage());
        }
    }
    
    private void resetProdiForm() {
        namaProdiText.setText("");
        
        String generatedCode = prodiModel.getAutoCode();
        kodeProdiText.setText(generatedCode);
        
        comboJenjang.removeAllItems();
        comboJenjang.addItem("D1");
        comboJenjang.addItem("D2");
        comboJenjang.addItem("D3");
        comboJenjang.addItem("D4");
        comboJenjang.addItem("S1");
        comboJenjang.addItem("S2");
        comboJenjang.addItem("S3");
        
        //Btn
        btnSaveProdi.setEnabled(true);
        btnDeleteProdi.setEnabled(false);
        btnUpdateProdi.setEnabled(false);
        selectedProdiCode = "";
    }

    /*
     *   BUKU SECTION
     */
    private void btnResetBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetUserActionPerformed
        resetBukuForm();
    }//GEN-LAST:event_btnResetUserActionPerformed

    private void bukuDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bukuDataTableMouseClicked
        int row = bukuDataTable.getSelectedRow();
        if(row >= 0) {
            String kodeBuku = (bukuDataTable.getModel().getValueAt(row, 0).toString());
            if(! kodeBuku.equals("")) {
                try {
                    ResultSet bukuData = bukuModel.getBukuByCode(kodeBuku);
                    if(bukuData.next()) {
                        String isbn = bukuData.getString("isbn");
                        String judul = bukuData.getString("judul");
                        int idKategori = bukuData.getInt("id_kategori");
                        String penerbit = bukuData.getString("penerbit");
                        String pengarang = bukuData.getString("pengarang");
                        String sinopsis = bukuData.getString("sinopsis");
                        
                        ResultSet kategoriData = kategoriModel.getKategoriById(Integer.toString(idKategori));
                        if(kategoriData.next()){
                            String kategori = kategoriData.getString("nama_kategori");
                            comboKategori.setSelectedItem(kategori);
                        }

                        selectedKodeBuku = kodeBuku;
                        kodeBukuText.setText(kodeBuku);
                        isbnText.setText(isbn);
                        judulText.setText(judul);
                        
                        pengarangText.setText(pengarang);
                        penerbitText.setText(penerbit);
                        sinopsisText.setText(sinopsis);                        

                        btnSaveBuku.setEnabled(false);
                        btnDeleteBuku.setEnabled(true);
                        btnUpdateBuku.setEnabled(true);
                    }
                } catch (SQLException e) {
                    helper.showMessage(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_bukuDataTableMouseClicked

    private void dataBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataBukuActionPerformed
        showContent(bukuPanel);
    }//GEN-LAST:event_dataBukuActionPerformed

    private void btnUpdateBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBukuActionPerformed
        if(! selectedKodeBuku.equals("")) {
            HashMap<String, Integer> map = populateCategory();
            String idCategory = comboKategori.getSelectedItem().toString();
            int selectedIdCategory = map.get(idCategory);
            String ISBN = isbnText.getText();
            String judul = judulText.getText();
            String penerbit = penerbitText.getText();
            String pengarang = pengarangText.getText();
            String sinopsis = sinopsisText.getText();

            if(selectedIdCategory <= 0 || ISBN.equals("") || judul.equals("") || penerbit.equals("") || pengarang.equals("") || sinopsis.equals("")) {
                helper.showMessage(bukuPanel, "Semua inputan harus diisi!");
            } else {
                bukuModel.setUpdateValue(judul, ISBN, selectedIdCategory, penerbit, pengarang, sinopsis, selectedKodeBuku);
                bukuModel.updateBuku();
                helper.showMessage(bukuPanel, "Data buku baru berhasil disimpan!");
                resetBukuForm();
                loadBukuData();
            }
        }
    }//GEN-LAST:event_btnUpdateBukuActionPerformed

    private void btnDeleteBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBukuActionPerformed
        if(! selectedKodeBuku.equals("")) {
            int confirmDialog = helper.confirmDialog(this, "Anda yakin akan menghapus data ini?", "Konfirmasi Hapus data");
            if(confirmDialog == 0){
                bukuModel.deleteBuku(selectedKodeBuku);
                helper.showMessage(this, "Data buku berhasil dihapus!");
                
                resetBukuForm();
                loadBukuData();
            }
        }
    }//GEN-LAST:event_btnDeleteBukuActionPerformed

    private void btnSaveBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBukuActionPerformed
        HashMap<String, Integer> map = populateCategory();
        String idCategory = comboKategori.getSelectedItem().toString();
        
        String kodeBuku = bukuModel.getAutoCode();
        String ISBN = isbnText.getText();
        String judul = judulText.getText();
        String penerbit = penerbitText.getText();
        String pengarang = pengarangText.getText();
        String sinopsis = sinopsisText.getText();

        if(idCategory.equals("") || kodeBuku.equals("") || ISBN.equals("") || judul.equals("") || penerbit.equals("") || pengarang.equals("") || sinopsis.equals("")) {
            helper.showMessage(bukuPanel, "Semua inputan harus diisi!");
        } else {
            int selectedIdCategory = map.get(idCategory);
            
            bukuModel.setValue(kodeBuku, judul, ISBN, selectedIdCategory, penerbit, pengarang, sinopsis);
            bukuModel.insertBuku();
            helper.showMessage(bukuPanel, "Data buku baru berhasil disimpan!");
            resetBukuForm();
            loadBukuData();
        }
    }//GEN-LAST:event_btnSaveBukuActionPerformed

    private void loadBukuData() {
        bukuTableModel.getDataVector().removeAllElements();
        bukuTableModel.fireTableDataChanged();
        try {
            ResultSet bukuData = bukuModel.getBukuWithCategory();
            while(bukuData.next()) {
                Object[] dataObject = new Object[6];
                dataObject[0] = bukuData.getString("kode_buku");
                dataObject[1] = bukuData.getString("isbn");
                dataObject[2] = bukuData.getString("judul");
                dataObject[3] = bukuData.getString("kategori");
                dataObject[4] = bukuData.getString("penerbit");
                dataObject[5] = bukuData.getString("pengarang");
                
                bukuTableModel.addRow(dataObject); 
            }
        } catch (SQLException e) {
            helper.showMessage(this, e.getMessage());
        }
    }

    private void resetBukuForm() {
        String generatedCode = bukuModel.getAutoCode();
        kodeBukuText.setText(generatedCode);
        isbnText.setText("");
        judulText.setText("");
        judulText.setEnabled(true);
        pengarangText.setText("");
        penerbitText.setText("");
        comboKategori.removeAllItems();
        comboKategori.addItem("-- Pilih Kategori Buku --");
        
        HashMap<String, Integer> map = populateCategory();
        map.keySet().forEach((s) -> {
            comboKategori.addItem(s);
        });
        
        sinopsisText.setText("");
        
        //Btn
        btnSaveBuku.setEnabled(true);
        btnDeleteBuku.setEnabled(false);
        btnUpdateBuku.setEnabled(false);
        selectedKodeBuku = "";
    }

    /*
     *   MAHASISWA SECTION
     */
    private void btnResetMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetMhsActionPerformed
        resetMahasiswaForm();
    }//GEN-LAST:event_btnResetMhsActionPerformed

    private void btnSaveMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMhsActionPerformed
        HashMap<String, Integer> map = populateProgramStudi();
        String idProdi = comboProdi.getSelectedItem().toString();
        
        String nim = nimText.getText();
        String namaLengkap = namaMhsText.getText();
        String jk = helper.getGender(comboJK.getSelectedItem().toString());
        String telpon = telponMhsText.getText();
        String alamat = alamatText.getText();
        String smt = comboSemester.getSelectedItem().toString();
        

        if(idProdi.equals("") || nim.equals("") || namaLengkap.equals("") || jk.equals("") || telpon.equals("") || alamat.equals("") || smt.equals("")) {
            helper.showMessage(mahasiswaPanel, "Semua inputan harus diisi!");
        } else {
            int selectedIdProdi = map.get(idProdi);
            int semester = Integer.parseInt(smt);
            
            mhsModel.setValue(nim, namaLengkap, jk, semester, selectedIdProdi, alamat, telpon);
            mhsModel.insertMahasiswa();
            helper.showMessage(mahasiswaPanel, "Data mahasiswa baru berhasil disimpan!");
            resetMahasiswaForm();
            loadMahasiswaData();
        }
    }//GEN-LAST:event_btnSaveMhsActionPerformed

    private void btnDeleteMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMhsActionPerformed
        if(! selectedNim.equals("")) {
            int confirmDialog = helper.confirmDialog(this, "Anda yakin akan menghapus data ini?", "Konfirmasi Hapus data");
            if(confirmDialog == 0){
                mhsModel.deleteMahasiswa(selectedNim);
                helper.showMessage(this, "Data mahasiswa berhasil dihapus!");
                
                resetBukuForm();
                loadBukuData();
            }
        }
    }//GEN-LAST:event_btnDeleteMhsActionPerformed

    private void btnUpdateMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMhsActionPerformed
        if(! selectedNim.equals("")) {
            HashMap<String, Integer> map = populateProgramStudi();
            String idProdi = comboProdi.getSelectedItem().toString();            
            String namaLengkap = namaMhsText.getText();
            String jk = helper.getGender(comboJK.getSelectedItem().toString());
            String telpon = telponMhsText.getText();
            String alamat = alamatText.getText();
            String smt = comboSemester.getSelectedItem().toString();

            if(idProdi.equals("") || namaLengkap.equals("") || jk.equals("") || telpon.equals("") || alamat.equals("") || smt.equals("")) {
                helper.showMessage(mahasiswaPanel, "Semua inputan harus diisi!");
            } else {
                int selectedIdProdi = map.get(idProdi);
                int semester = Integer.parseInt(smt);
                mhsModel.setValue(selectedNim, namaLengkap, jk, semester, selectedIdProdi, alamat, telpon);
                mhsModel.updateMahasiswa();
                helper.showMessage(mahasiswaPanel, "Data mahasiswa baru berhasil disimpan!");
                resetMahasiswaForm();
                loadMahasiswaData();
            }
        }
    }//GEN-LAST:event_btnUpdateMhsActionPerformed

    private void mhsDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mhsDataTableMouseClicked
        int row = mhsDataTable.getSelectedRow();
        if(row >= 0) {
            String nim = (mhsDataTable.getModel().getValueAt(row, 0).toString());
            if(! nim.equals("")) {
                try {
                    ResultSet mhsData = mhsModel.getMahasiswaByNIM(nim);
                    if(mhsData.next()) {
                        String namaMhs = mhsData.getString("nama_lengkap");
                        String jk = helper.getGender(mhsData.getString("jk"));
                        String telpon = mhsData.getString("telpon");
                        String alamat = mhsData.getString("alamat");
                        int semester = mhsData.getInt("semester");
                        
                        String idProdi = Integer.toString(mhsData.getInt("id_prodi"));
                        ResultSet dataProdi = prodiModel.getProdiById(idProdi);
                        if(dataProdi.next()){
                            String jenjang = dataProdi.getString("jenjang");
                            String selectedProdi = dataProdi.getString("nama");
                            String prodi = jenjang +" - "+ selectedProdi;
                            comboProdi.setSelectedItem(prodi);
                        }
                        
                        nimText.setText(nim);
                        namaMhsText.setText(namaMhs);
                        telponMhsText.setText(telpon);
                        comboJK.setSelectedItem(jk);
                        alamatText.setText(alamat);
                        comboSemester.setSelectedItem(Integer.toString(semester));

                        selectedNim = nim;                        

                        btnSaveMhs.setEnabled(false);
                        btnDeleteMhs.setEnabled(true);
                        btnUpdateMhs.setEnabled(true);
                    }
                } catch (SQLException e) {
                    helper.showMessage(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_mhsDataTableMouseClicked

    private void resetMahasiswaForm() {
        nimText.setText("");
        namaMhsText.setText("");
        comboJK.removeAllItems();
        comboJK.addItem("-- Pilih Jenis Kelamin --");
        comboJK.addItem("Laki-laki");
        comboJK.addItem("Perempuan");
        telponMhsText.setText("");
        alamatText.setText("");
        
        comboSemester.removeAllItems();
        comboSemester.addItem("-- Pilih Semester --");
        
        for (int i = 1; i <= 8; i++) {
            comboSemester.addItem(Integer.toString(i));
        }
        
        comboProdi.removeAllItems();
        comboProdi.addItem("-- Pilih Program Studi --");
        HashMap<String, Integer> map = populateProgramStudi();
        map.keySet().forEach((s) -> {
            comboProdi.addItem(s);
        });
        
        //Btn
        btnSaveMhs.setEnabled(true);
        btnDeleteMhs.setEnabled(false);
        btnUpdateMhs.setEnabled(false);
        selectedNim = "";
    }

    private void loadMahasiswaData() {
        mhsTableModel.getDataVector().removeAllElements();
        mhsTableModel.fireTableDataChanged();
        
        try {
            ResultSet mahasiswaData = mhsModel.getMahasiswaWithProdi();
            while(mahasiswaData.next()) {
                Object[] dataObject = new Object[6];
                dataObject[0] = mahasiswaData.getInt("nim");
                dataObject[1] = mahasiswaData.getString("nama_lengkap");
                dataObject[2] = helper.getGender(mahasiswaData.getString("jk"));
                dataObject[3] = mahasiswaData.getString("prodi");
                dataObject[4] = mahasiswaData.getString("semester");
                dataObject[5] = mahasiswaData.getString("telpon");               
                
                mhsTableModel.addRow(dataObject); 
            }
        } catch (SQLException e) {
            helper.showMessage(this, e.getMessage());
        }
    }
    
    /* Mapping category */
    private HashMap<String, Integer> populateCategory() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            ResultSet kategoriData = kategoriModel.loadData();
            Item categoryItem;
            
            while(kategoriData.next()) {
                int idKategori = kategoriData.getInt("id_kategori");
                String namaKategori = kategoriData.getString("nama_kategori");
                categoryItem = new Item(idKategori, namaKategori);
                map.put(
                        categoryItem.getName(), categoryItem.getId()
                );
            }
        } catch (SQLException e) {
            helper.showMessage(this, e.getMessage());
        }
        
        return map;
    }
    
    /* Mapping programStudi */
    private HashMap<String, Integer> populateProgramStudi() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            ResultSet prodiData = prodiModel.loadData();
            Item prodiItem;
            
            while(prodiData.next()) {
                int idProdi = prodiData.getInt("id_prodi");
                String namaProdi = prodiData.getString("nama");
                String jenjang = prodiData.getString("jenjang");
                String prodiName = jenjang +" - " + namaProdi;
                prodiItem = new Item(idProdi, prodiName);
                map.put(
                        prodiItem.getName(), prodiItem.getId()
                );
            }
        } catch (SQLException e) {
            helper.showMessage(this, e.getMessage());
        }
        
        return map;
    }    
 
    /* Dynamic showing panel as content */
    private void showContent(javax.swing.JPanel panelName) {
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(panelName);
        panelName.setLocation(0,0);
        panelName.setSize(1366, 768);
        panelName.setBackground(new Color(240, 240, 240));
        
        mainPanel.repaint();
        mainPanel.revalidate();        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatText;
    private javax.swing.JLabel appName;
    private javax.swing.JButton btnDeleteBuku;
    private javax.swing.JButton btnDeleteKategori;
    private javax.swing.JButton btnDeleteMhs;
    private javax.swing.JButton btnDeleteProdi;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnResetBuku;
    private javax.swing.JButton btnResetKategori;
    private javax.swing.JButton btnResetMhs;
    private javax.swing.JButton btnResetProdi;
    private javax.swing.JButton btnResetUser;
    private javax.swing.JButton btnSaveBuku;
    private javax.swing.JButton btnSaveKategori;
    private javax.swing.JButton btnSaveMhs;
    private javax.swing.JButton btnSaveProdi;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnUpdateBuku;
    private javax.swing.JButton btnUpdateKategori;
    private javax.swing.JButton btnUpdateMhs;
    private javax.swing.JButton btnUpdateProdi;
    private javax.swing.JButton btnUpdateUser;
    private javax.swing.JPanel bukuDataPanel;
    private javax.swing.JTable bukuDataTable;
    private javax.swing.JPanel bukuFormPanel;
    private javax.swing.JPanel bukuPanel;
    private javax.swing.JComboBox<String> comboHakAkses;
    private javax.swing.JComboBox<String> comboJK;
    private javax.swing.JComboBox<String> comboJenjang;
    private javax.swing.JComboBox<String> comboKategori;
    private javax.swing.JComboBox<String> comboProdi;
    private javax.swing.JComboBox<String> comboSemester;
    private javax.swing.JMenuItem dataBuku;
    private javax.swing.JMenuItem dataMahasiswa;
    private javax.swing.JMenu dataMaster;
    private javax.swing.JMenuItem dataProgramStudi;
    private javax.swing.JMenu home;
    private javax.swing.JPanel homePanel;
    private javax.swing.JTextField isbnText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField judulText;
    private javax.swing.JMenuItem kategoriBuku;
    private javax.swing.JPanel kategoriDataPanel;
    private javax.swing.JTable kategoriDataTable;
    private javax.swing.JPanel kategoriFormPanel;
    private javax.swing.JPanel kategoriPanel;
    private javax.swing.JMenu keluar;
    private javax.swing.JTextField kodeBukuText;
    private javax.swing.JTextField kodeProdiText;
    private javax.swing.JPanel mahasiswaDataPanel;
    private javax.swing.JPanel mahasiswaFormPanel;
    private javax.swing.JPanel mahasiswaPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenu manajemenPengguna;
    private javax.swing.JTable mhsDataTable;
    private javax.swing.JMenuBar myMenuBar;
    private javax.swing.JTextField namaKategoriText;
    private javax.swing.JTextField namaLengkapText;
    private javax.swing.JTextField namaMhsText;
    private javax.swing.JTextField namaProdiText;
    private javax.swing.JTextField nimText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField penerbitText;
    private javax.swing.JTextField pengarangText;
    private javax.swing.JPanel prodiDataPanel;
    private javax.swing.JTable prodiDataTable;
    private javax.swing.JPanel prodiFormPanel;
    private javax.swing.JPanel prodiPanel;
    private javax.swing.JTextArea sinopsisText;
    private javax.swing.JTextField telponMhsText;
    private javax.swing.JTextField telponText;
    private javax.swing.JPanel userDataPanel;
    private javax.swing.JTable userDataTable;
    private javax.swing.JPanel userFormPanel;
    private javax.swing.JLabel userLoggedInStatus;
    private javax.swing.JPanel userPanel;
    private javax.swing.JTextField usernameText;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
