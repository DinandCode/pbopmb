/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.delimare.pmb.gui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import org.delimare.pmb.connection.Koneksi;
import org.delimare.pmb.entity.Alamat;
import org.delimare.pmb.entity.BiodataOrangTua;
import org.delimare.pmb.entity.CalonMahasiswa;
import org.delimare.pmb.entity.ProgramStudi;
import org.delimare.pmb.entity.RiwayatPendidikan;
import org.delimare.pmb.entitymanager.AlamatManager;
import org.delimare.pmb.entitymanager.BiodataOrangTuaManager;
import org.delimare.pmb.entitymanager.CalonMahasiswaManager;
import org.delimare.pmb.entitymanager.ProgramStudiManager;
import org.delimare.pmb.entitymanager.RiwayatPendidikanManager;
import org.delimare.pmb.function.Alert;
import org.delimare.pmb.function.Logger;
import org.delimare.pmb.function.Utils;

/**
 *
 * @author smart user
 */
public class FormTambahPeserta extends javax.swing.JFrame {

    private Koneksi db;
    private Connection conn;

    private AlamatManager alamatManager;
    private ProgramStudiManager programStudiManager;
    private CalonMahasiswaManager calonMahasiswaManager;
    private RiwayatPendidikanManager riwayatPendidikanManager;
    private BiodataOrangTuaManager biodataOrangTuaManager;

    /**
     * Creates new form FormTambahPeserta
     */
    public FormTambahPeserta() {
        initComponents();

        db = new Koneksi();
        alamatManager = new AlamatManager();
        conn = db.getConnection();
        programStudiManager = new ProgramStudiManager();
        calonMahasiswaManager = new CalonMahasiswaManager();
        riwayatPendidikanManager = new RiwayatPendidikanManager();
        biodataOrangTuaManager = new BiodataOrangTuaManager();

        loadComboProgramStudi();
    }

    private boolean inputValid() {
        if (txtRt.getText().length() == 0) {
            Alert.warning("Kolom RT wajib diisi");
            return false;
        }

        if (txtRt.getText().length() == 0) {
            Alert.warning("Kolom RW wajib diisi");
            return false;
        }

        if (txtKecamatan.getText().length() == 0) {
            Alert.warning("Kolom Kecamatan wajib diisi");
            return false;
        }

        if (txtKabupaten.getText().length() == 0) {
            Alert.warning("Kolom Kabupaten wajib diisi");
            return false;
        }

        if (txtProvinsi.getText().length() == 0) {
            Alert.warning("Kolom Provinsi wajib diisi");
            return false;
        }

        if (txtKodePos.getText().length() == 0) {
            Alert.warning("Kolom Kode Pos wajib diisi");
            return false;
        }

        if (txtAlamat.getText().length() == 0) {
            Alert.warning("Kolom Alamat wajib diisi");
            return false;
        }

        if (txtNIKPeserta.getText().length() == 0) {
            Alert.warning("Kolom NIK Peserta wajib diisi");
            return false;
        }

        if (txtNamaPeserta.getText().length() == 0) {
            Alert.warning("Kolom Nama Peserta wajib diisi");
            return false;
        }

        if (txtTempatLahir.getText().length() == 0) {
            Alert.warning("Kolom Tempat Lahir wajib diisi");
            return false;
        }

        if (calendarTglLahir.getDate() == null) {
            Alert.warning("Kolom Tanggal Lahir wajib diisi");
            return false;
        }

        if (comboAgama.getSelectedIndex() == -1) {
            Alert.warning("Kolom Agama wajib diisi");
            return false;
        }

        if (comboStatusPerkawinan.getSelectedIndex() == -1) {
            Alert.warning("Kolom Status Perkawinan wajib diisi");
            return false;
        }

        if (txtJumlahAnak.getText().length() == 0) {
            Alert.warning("Kolom Jumlah Anak wajib diisi");
            return false;
        }

        if (txtNISN.getText().length() == 0) {
            Alert.warning("Kolom NISN wajib diisi");
            return false;
        }

        if (comboJenisKelamin.getSelectedIndex() == -1) {
            Alert.warning("Kolom Jenis Kelamin wajib diisi");
            return false;
        }

        if (txtNoTelepon.getText().length() == 0) {
            Alert.warning("Kolom No Telepon wajib diisi");
            return false;
        }

        if (txtEmail.getText().length() == 0) {
            Alert.warning("Kolom Email wajib diisi");
            return false;
        }

        if (comboProgramStudi.getSelectedIndex() == -1) {
            Alert.warning("Kolom Program Studi wajib diisi");
            return false;
        }

        if (numTahunDaftar.getYear() == 0) {
            Alert.warning("Kolom Tahun Daftar wajib diisi");
            return false;
        }

        if (comboStatusPendaftaran.getSelectedIndex() == -1) {
            Alert.warning("Kolom Status Pendaftaran wajib diisi");
            return false;
        }

        if (txtNamaSekolahSd.getText().length() == 0) {
            Alert.warning("Kolom Nama Sekolah SD wajib diisi");
            return false;
        }

        if (txtNamaSekolahSMP.getText().length() == 0) {
            Alert.warning("Kolom Nama Sekolah SMP wajib diisi");
            return false;
        }

        if (txtNamaSekolahSMA.getText().length() == 0) {
            Alert.warning("Kolom Nama Sekolah SMA wajib diisi");
            return false;
        }

        if (txtNamaKabupatenSD.getText().length() == 0) {
            Alert.warning("Kolom Nama Kabupaten SD wajib diisi");
            return false;
        }

        if (txtNamaKabupatenSMP.getText().length() == 0) {
            Alert.warning("Kolom Nama Kabupaten SMP wajib diisi");
            return false;
        }

        if (txtNamaKabupatenSMA.getText().length() == 0) {
            Alert.warning("Kolom Nama Kabupaten SMA wajib diisi");
            return false;
        }

        if (txtNamaProvinsiSD.getText().length() == 0) {
            Alert.warning("Kolom Nama Provinsi SD wajib diisi");
            return false;
        }

        if (txtNamaProvinsiSMP.getText().length() == 0) {
            Alert.warning("Kolom Nama Provinsi SMP wajib diisi");
            return false;
        }

        if (txtNamaProvinsiSMA.getText().length() == 0) {
            Alert.warning("Kolom Nama Provinsi SMA wajib diisi");
            return false;
        }

        if (numTahunLulusSD.getYear() == 0) {
            Alert.warning("Kolom Tahun Lulus SD wajib diisi");
            return false;
        }

        if (numTahunLulusSMP.getYear() == 0) {
            Alert.warning("Kolom Tahun Lulus SMP wajib diisi");
            return false;
        }

        if (numTahunLulusSMA.getYear() == 0) {
            Alert.warning("Kolom Tahun Lulus SMA wajib diisi");
            return false;
        }

        if (txtNamaAyah.getText().length() == 0) {
            Alert.warning("Kolom Nama Ayah wajib diisi");
            return false;
        }

        if (txtAlamatAyah.getText().length() == 0) {
            Alert.warning("Kolom Alamat Ayah wajib diisi");
            return false;
        }

        if (txtPendidikanAyah.getText().length() == 0) {
            Alert.warning("Kolom Pendidikan Ayah wajib diisi");
            return false;
        }

        if (txtPekerjaanAyah.getText().length() == 0) {
            Alert.warning("Kolom Pekerjaan Ayah wajib diisi");
            return false;
        }

        if (comboStatusAyah.getSelectedIndex() == -1) {
            Alert.warning("Kolom Status Ayah wajib diisi");
            return false;
        }

        if (txtNoHpAyah.getText().length() == 0) {
            Alert.warning("Kolom No HP Ayah wajib diisi");
            return false;
        }

        if (txtNIPAyah.getText().length() == 0) {
            Alert.warning("Kolom NIP Ayah wajib diisi");
            return false;
        }

        if (txtPangkatAyah.getText().length() == 0) {
            Alert.warning("Kolom Pangkat Ayah wajib diisi");
            return false;
        }

        if (txtJabatanAyah.getText().length() == 0) {
            Alert.warning("Kolom Jabatan Ayah wajib diisi");
            return false;
        }

        if (txtInstansiAyah.getText().length() == 0) {
            Alert.warning("Kolom Instansi Ayah wajib diisi");
            return false;
        }

        if (txtNamaIbu.getText().length() == 0) {
            Alert.warning("Kolom Nama Ibu wajib diisi");
            return false;
        }

        if (txtAlamatIbu.getText().length() == 0) {
            Alert.warning("Kolom Alamat Ibu wajib diisi");
            return false;
        }

        if (txtPendidikanIbu.getText().length() == 0) {
            Alert.warning("Kolom Pendidikan Ibu wajib diisi");
            return false;
        }

        if (txtPekerjaanIbu.getText().length() == 0) {
            Alert.warning("Kolom Pekerjaan Ibu wajib diisi");
            return false;
        }

        if (comboStatusIbu.getSelectedIndex() == -1) {
            Alert.warning("Kolom Status Ibu wajib diisi");
            return false;
        }

        if (txtNoHpIbu.getText().length() == 0) {
            Alert.warning("Kolom No HP Ibu wajib diisi");
            return false;
        }

        if (txtNIPIbu.getText().length() == 0) {
            Alert.warning("Kolom NIP Ibu wajib diisi");
            return false;
        }

        if (txtPangkatIbu.getText().length() == 0) {
            Alert.warning("Kolom Pangkat Ibu wajib diisi");
            return false;
        }

        if (txtJabatanIbu.getText().length() == 0) {
            Alert.warning("Kolom Jabatan Ibu wajib diisi");
            return false;
        }

        if (txtInstansiIbu.getText().length() == 0) {
            Alert.warning("Kolom Instansi Ibu wajib diisi");
            return false;
        }

        return true;
    }

    private void loadComboProgramStudi() {
        ArrayList<ProgramStudi> programStudi = programStudiManager.getSemua("");
        comboProgramStudi.setModel(new DefaultComboBoxModel(programStudi.toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIDPeserta = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNIKPeserta = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNamaPeserta = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtNISN = new javax.swing.JTextPane();
        calendarTglLahir = new com.toedter.calendar.JCalendar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboStatusPerkawinan = new javax.swing.JComboBox();
        comboAgama = new javax.swing.JComboBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtTempatLahir = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtJumlahAnak = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtEmail = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtNoTelepon = new javax.swing.JTextPane();
        comboStatusPendaftaran = new javax.swing.JComboBox();
        comboProgramStudi = new javax.swing.JComboBox();
        numTahunDaftar = new com.toedter.calendar.JYearChooser();
        comboJenisKelamin = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtIdCalon = new javax.swing.JTextPane();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtNamaAyah = new javax.swing.JTextPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtAlamatAyah = new javax.swing.JTextPane();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtPangkatAyah = new javax.swing.JTextPane();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        comboStatusAyah = new javax.swing.JComboBox();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtPendidikanAyah = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtJabatanAyah = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        txtNIPAyah = new javax.swing.JTextPane();
        jScrollPane20 = new javax.swing.JScrollPane();
        txtInstansiAyah = new javax.swing.JTextPane();
        jScrollPane21 = new javax.swing.JScrollPane();
        txtPekerjaanAyah = new javax.swing.JTextPane();
        jScrollPane22 = new javax.swing.JScrollPane();
        txtNoHpAyah = new javax.swing.JTextPane();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        txtNoHpIbu = new javax.swing.JTextPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtNamaIbu = new javax.swing.JTextPane();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        txtAlamatIbu = new javax.swing.JTextPane();
        jScrollPane26 = new javax.swing.JScrollPane();
        txtPendidikanIbu = new javax.swing.JTextPane();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        txtJabatanIbu = new javax.swing.JTextPane();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        txtNIPIbu = new javax.swing.JTextPane();
        comboStatusIbu = new javax.swing.JComboBox();
        jScrollPane29 = new javax.swing.JScrollPane();
        txtPekerjaanIbu = new javax.swing.JTextPane();
        jScrollPane30 = new javax.swing.JScrollPane();
        txtInstansiIbu = new javax.swing.JTextPane();
        jScrollPane31 = new javax.swing.JScrollPane();
        txtPangkatIbu = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtNamaSekolahSd = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        numTahunLulusSD = new com.toedter.calendar.JYearChooser();
        jTextField5 = new javax.swing.JTextField();
        txtNamaSekolahSMP = new javax.swing.JTextField();
        numTahunLulusSMP = new com.toedter.calendar.JYearChooser();
        jTextField8 = new javax.swing.JTextField();
        txtNamaSekolahSMA = new javax.swing.JTextField();
        numTahunLulusSMA = new com.toedter.calendar.JYearChooser();
        txtNamaKabupatenSD = new javax.swing.JTextField();
        txtNamaProvinsiSD = new javax.swing.JTextField();
        txtNamaKabupatenSMP = new javax.swing.JTextField();
        txtNamaKabupatenSMA = new javax.swing.JTextField();
        txtNamaProvinsiSMP = new javax.swing.JTextField();
        txtNamaProvinsiSMA = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        txtIdAlamat = new javax.swing.JTextPane();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        txtRt = new javax.swing.JTextPane();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        txtRw = new javax.swing.JTextPane();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        txtKecamatan = new javax.swing.JTextPane();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        txtKabupaten = new javax.swing.JTextPane();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane36 = new javax.swing.JScrollPane();
        txtProvinsi = new javax.swing.JTextPane();
        jScrollPane37 = new javax.swing.JScrollPane();
        txtKodePos = new javax.swing.JTextPane();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane38 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextPane();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnKelolaBerkas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Biodata Peserta");

        txtIDPeserta.setEditable(false);
        jScrollPane1.setViewportView(txtIDPeserta);

        jLabel2.setText("ID PESERTA");

        jLabel3.setText("NIK");

        txtNIKPeserta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNIKPesertaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtNIKPeserta);

        jScrollPane3.setViewportView(txtNamaPeserta);

        jLabel4.setText("NAMA");

        jLabel5.setText("TEMPAT LAHIR");

        jLabel6.setText("TANGGAL LAHIR");

        txtNISN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNISNKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(txtNISN);

        jLabel7.setText("AGAMA");

        jLabel8.setText("STATUS PERKAWINAN");

        jLabel9.setText("JUMLAH ANAK");

        jLabel10.setText("NISN");

        jLabel11.setText("JENIS KELAMIN");

        jLabel12.setText("NO TELEPON");

        jLabel13.setText("EMAIL");

        jLabel14.setText("TAHUN DAFTAR");

        jLabel15.setText("STATUS PENDAFTARAN");

        jLabel16.setText("PROGRAM STUDI");

        comboStatusPerkawinan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BELUM MENIKAH", "MENIKAH", "JANDA", "DUDA" }));

        comboAgama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Islam", "Kristen", "Katolik", "Kristen Protestan", "Hindu", "Buddha" }));

        jScrollPane7.setViewportView(txtTempatLahir);

        txtJumlahAnak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahAnakKeyTyped(evt);
            }
        });
        jScrollPane9.setViewportView(txtJumlahAnak);

        jScrollPane10.setViewportView(txtEmail);

        txtNoTelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoTeleponKeyTyped(evt);
            }
        });
        jScrollPane12.setViewportView(txtNoTelepon);

        comboStatusPendaftaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending", "Lulus", "Tidak Lulus" }));

        comboProgramStudi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboJenisKelamin, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numTahunDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboProgramStudi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboStatusPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboAgama, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboStatusPerkawinan, javax.swing.GroupLayout.Alignment.LEADING, 0, 178, Short.MAX_VALUE))))
                    .addComponent(calendarTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane7)))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(calendarTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboStatusPerkawinan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(comboJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(comboProgramStudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(comboStatusPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(numTahunDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel18.setText("BIODATA AYAH");

        txtIdCalon.setEditable(false);
        jScrollPane4.setViewportView(txtIdCalon);

        jLabel19.setText("ID CALON");

        jLabel20.setText("NAMA AYAH ");

        jScrollPane6.setViewportView(txtNamaAyah);

        jScrollPane13.setViewportView(txtAlamatAyah);

        jLabel21.setText("ALAMAT AYAH");

        jLabel22.setText("PENDIDIKAN AYAH");

        jScrollPane14.setViewportView(txtPangkatAyah);

        jLabel24.setText("PEKERJAAN AYAH");

        jLabel25.setText("STATUS AYAH");

        jLabel26.setText("NO HP AYAH");

        jLabel27.setText("NIP  AYAH");

        jLabel28.setText("PANGKAT AYAH");

        jLabel29.setText("JABATAN AYAH");

        jLabel30.setText("INSTANSI AYAH");

        comboStatusAyah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane15.setViewportView(txtPendidikanAyah);

        jScrollPane16.setViewportView(txtJabatanAyah);

        jScrollPane17.setViewportView(txtNIPAyah);

        jScrollPane20.setViewportView(txtInstansiAyah);

        jScrollPane21.setViewportView(txtPekerjaanAyah);

        txtNoHpAyah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoHpAyahKeyTyped(evt);
            }
        });
        jScrollPane22.setViewportView(txtNoHpAyah);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel23.setText("BIODATA IBU");

        txtNoHpIbu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoHpIbuKeyTyped(evt);
            }
        });
        jScrollPane24.setViewportView(txtNoHpIbu);

        jScrollPane18.setViewportView(txtNamaIbu);

        jLabel31.setText("NAMA IBU");

        jLabel33.setText("ALAMAT IBU");

        jScrollPane25.setViewportView(txtAlamatIbu);

        jScrollPane26.setViewportView(txtPendidikanIbu);

        jLabel35.setText("PENDIDIKAN IBU");

        jLabel36.setText("PEKERJAAN IBU");

        jScrollPane27.setViewportView(txtJabatanIbu);

        jLabel37.setText("STATUS IBU");

        jLabel38.setText("NO HP IBU");

        jLabel39.setText("NIP IBU");

        jLabel40.setText("PANGKAT IBU");

        jLabel41.setText("JABATAN IBU");

        jLabel42.setText("INSTANSI IBU");

        jScrollPane28.setViewportView(txtNIPIbu);

        comboStatusIbu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane29.setViewportView(txtPekerjaanIbu);

        jScrollPane30.setViewportView(txtInstansiIbu);

        jScrollPane31.setViewportView(txtPangkatIbu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel30)))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboStatusAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                .addComponent(jScrollPane6)
                                .addComponent(jScrollPane13)
                                .addComponent(jScrollPane15)
                                .addComponent(jScrollPane21))
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel41)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40)
                                            .addComponent(jLabel39))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboStatusIbu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                        .addComponent(jScrollPane25)
                                        .addComponent(jScrollPane26)
                                        .addComponent(jScrollPane29))
                                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(273, 273, 273))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(491, 491, 491))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(comboStatusAyah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel37))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(comboStatusIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel41))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel43.setText("NAMA SEKOLAH");

        jLabel44.setText("SEKOLAH");

        jLabel45.setText("KABUPATEN");

        jLabel46.setText("PROVINSI");

        jLabel47.setText("TAHUN LULUS");

        txtNamaSekolahSd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaSekolahSdActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setText("SD");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setText("SMP");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        txtNamaSekolahSMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaSekolahSMPActionPerformed(evt);
            }
        });

        jTextField8.setEditable(false);
        jTextField8.setText("SMA");
        jTextField8.setToolTipText("");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        txtNamaSekolahSMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaSekolahSMAActionPerformed(evt);
            }
        });

        txtNamaKabupatenSMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaKabupatenSMPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel43))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaSekolahSMA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(txtNamaSekolahSMP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNamaSekolahSd))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45)
                    .addComponent(txtNamaKabupatenSD)
                    .addComponent(txtNamaKabupatenSMP)
                    .addComponent(txtNamaKabupatenSMA, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel46)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel47))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaProvinsiSMP)
                                    .addComponent(txtNamaProvinsiSMA))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numTahunLulusSMA, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numTahunLulusSMP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNamaProvinsiSD, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(numTahunLulusSD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(9, 9, 9))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaSekolahSd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaKabupatenSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaProvinsiSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(numTahunLulusSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaSekolahSMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaKabupatenSMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaProvinsiSMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(numTahunLulusSMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaSekolahSMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaKabupatenSMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaProvinsiSMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(numTahunLulusSMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtIdAlamat.setEditable(false);
        jScrollPane19.setViewportView(txtIdAlamat);

        jLabel48.setText("ID ");

        txtRt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRtKeyTyped(evt);
            }
        });
        jScrollPane23.setViewportView(txtRt);

        jLabel49.setText("RT");

        txtRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRwKeyReleased(evt);
            }
        });
        jScrollPane32.setViewportView(txtRw);

        jLabel50.setText("RW");

        jScrollPane33.setViewportView(txtKecamatan);

        jLabel51.setText("KECAMATAN");

        jLabel52.setText("KABUPATEN");

        jScrollPane34.setViewportView(txtKabupaten);

        jLabel54.setText("PROVINSI");

        jScrollPane36.setViewportView(txtProvinsi);

        txtKodePos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKodePosKeyTyped(evt);
            }
        });
        jScrollPane37.setViewportView(txtKodePos);

        jLabel55.setText("KODE POS");

        jScrollPane38.setViewportView(txtAlamat);

        jLabel56.setText("ALAMAT");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel57.setText("ISI ALAMAT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jLabel55)
                            .addComponent(jLabel54)
                            .addComponent(jLabel52)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel49)
                                        .addComponent(jLabel50))
                                    .addGap(109, 109, 109)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane23)
                                        .addComponent(jScrollPane32)
                                        .addComponent(jScrollPane33, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane34, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane36, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane37, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane38, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel48)
                                    .addGap(114, 114, 114)
                                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel51)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel57)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51)
                    .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel52)
                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel54)
                    .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel55)
                    .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56)
                    .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel32.setText("Tambah Data Peserta");

        jLabel34.setText("Lengkapi data diri peserta dan informasi tambahan lainnya");

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnKelolaBerkas.setText("Kelola berkas pendaftaran...");
        btnKelolaBerkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKelolaBerkasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 699, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnKelolaBerkas, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(btnKeluar)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34)
                            .addComponent(btnKeluar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnKelolaBerkas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaSekolahSdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaSekolahSdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaSekolahSdActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void txtNamaSekolahSMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaSekolahSMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaSekolahSMPActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void txtNamaSekolahSMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaSekolahSMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaSekolahSMAActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void txtNamaKabupatenSMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaKabupatenSMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKabupatenSMPActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (inputValid()) {
            try {
                try {
                    conn.setAutoCommit(false);
                    Alamat alamat = new Alamat();
                    alamat.setRt(Integer.parseInt(txtRt.getText()));
                    alamat.setRw(Integer.parseInt(txtRw.getText()));
                    alamat.setKecamatan(txtKecamatan.getText());
                    alamat.setKabupaten(txtKabupaten.getText());
                    alamat.setProvinsi(txtProvinsi.getText());
                    alamat.setKodePos(Integer.parseInt(txtKodePos.getText()));
                    alamat.setAlamat(txtAlamat.getText());
                    int idAlamat = alamatManager.insert(alamat, conn);

                    txtIdAlamat.setText(String.valueOf(idAlamat));

                    CalonMahasiswa calonMahasiswa = new CalonMahasiswa();
                    calonMahasiswa.setNikKtp(txtNIKPeserta.getText());
                    calonMahasiswa.setNamaLengkap(txtNamaPeserta.getText());
                    calonMahasiswa.setTempatLahir(txtTempatLahir.getText());
                    calonMahasiswa.setTanggalLahir(calendarTglLahir.getDate());
                    calonMahasiswa.setAgama(comboAgama.getSelectedItem().toString());
                    calonMahasiswa.setStatusPerkawinan(comboStatusPerkawinan.getSelectedItem().toString());
                    calonMahasiswa.setJumlahAnak(Integer.parseInt(txtJumlahAnak.getText()));
                    calonMahasiswa.setNisn(txtNISN.getText());
                    calonMahasiswa.setJenisKelamnin(comboJenisKelamin.getSelectedItem().toString());
                    calonMahasiswa.setNoTelepon(txtNoTelepon.getText());
                    calonMahasiswa.setEmail(txtEmail.getText());
                    ProgramStudi selected = (ProgramStudi) comboProgramStudi.getSelectedItem();
                    calonMahasiswa.setProgramStudi(selected.getKode());
                    calonMahasiswa.setTahunDaftar(numTahunDaftar.getYear());
                    calonMahasiswa.setStatusPendaftaran(comboStatusPendaftaran.getSelectedItem().toString());
                    calonMahasiswa.setIdAlamat(idAlamat);
                    int idCalon = calonMahasiswaManager.insert(calonMahasiswa, conn);

                    txtIdCalon.setText(String.valueOf(idCalon));
                    txtIDPeserta.setText(String.valueOf(idCalon));

                    RiwayatPendidikan riwayatSd = new RiwayatPendidikan();
                    riwayatSd.setSekolah("SD");
                    riwayatSd.setNamaSekolah(txtNamaSekolahSd.getText());
                    riwayatSd.setKabupaten(txtNamaKabupatenSD.getText());
                    riwayatSd.setProvinsi(txtNamaProvinsiSD.getText());
                    riwayatSd.setTahunLulus(numTahunLulusSD.getYear());
                    riwayatSd.setIdCalon(idCalon);
                    riwayatPendidikanManager.insert(riwayatSd, conn);

                    RiwayatPendidikan riwayatSmp = new RiwayatPendidikan();
                    riwayatSmp.setSekolah("SMP");
                    riwayatSmp.setNamaSekolah(txtNamaSekolahSMP.getText());
                    riwayatSmp.setKabupaten(txtNamaKabupatenSMP.getText());
                    riwayatSmp.setProvinsi(txtNamaProvinsiSMP.getText());
                    riwayatSmp.setTahunLulus(numTahunLulusSMP.getYear());
                    riwayatSmp.setIdCalon(idCalon);
                    riwayatPendidikanManager.insert(riwayatSmp, conn);

                    RiwayatPendidikan riwayatSma = new RiwayatPendidikan();
                    riwayatSma.setSekolah("SMA");
                    riwayatSma.setNamaSekolah(txtNamaSekolahSMA.getText());
                    riwayatSma.setKabupaten(txtNamaKabupatenSMA.getText());
                    riwayatSma.setProvinsi(txtNamaProvinsiSMA.getText());
                    riwayatSma.setTahunLulus(numTahunLulusSMA.getYear());
                    riwayatSma.setIdCalon(idCalon);
                    riwayatPendidikanManager.insert(riwayatSma, conn);

                    Alamat alamatAyah = new Alamat();
                    alamatAyah.setAlamat(txtAlamatAyah.getText());
                    int idAlamatAyah = alamatManager.insert(alamatAyah, conn);

                    Alamat alamatIbu = new Alamat();
                    alamatIbu.setAlamat(txtAlamatIbu.getText());
                    int idAlamatIbu = alamatManager.insert(alamatIbu, conn);

                    BiodataOrangTua biodataOrangTua = new BiodataOrangTua();
                    biodataOrangTua.setIdCalon(idCalon);
                    biodataOrangTua.setIdAlamatAyah(idAlamatAyah);
                    biodataOrangTua.setIdAlamatIbu(idAlamatIbu);

                    biodataOrangTua.setNamaAyah(txtNamaAyah.getText());
                    biodataOrangTua.setPendidikanAyah(txtPendidikanAyah.getText());
                    biodataOrangTua.setPekerjaanAyah(txtPekerjaanAyah.getText());
                    biodataOrangTua.setStatusAyah(comboStatusAyah.getSelectedItem().toString());
                    biodataOrangTua.setPangkatAyah(txtPangkatAyah.getText());
                    biodataOrangTua.setJabatanAyah(txtJabatanAyah.getText());
                    biodataOrangTua.setInstansiAyah(txtInstansiAyah.getText());
                    biodataOrangTua.setNoHpAyah(txtNoHpAyah.getText());
                    biodataOrangTua.setNipAyah(txtNIPAyah.getText());

                    biodataOrangTua.setNamaIbu(txtNamaIbu.getText());
                    biodataOrangTua.setPendidikanIbu(txtPendidikanIbu.getText());
                    biodataOrangTua.setPekerjaanIbu(txtPekerjaanIbu.getText());
                    biodataOrangTua.setStatusIbu(comboStatusIbu.getSelectedItem().toString());
                    biodataOrangTua.setPangkatIbu(txtPangkatIbu.getText());
                    biodataOrangTua.setJabatanIbu(txtJabatanIbu.getText());
                    biodataOrangTua.setInstansiIbu(txtInstansiIbu.getText());
                    biodataOrangTua.setNoHpIbu(txtNoHpIbu.getText());
                    biodataOrangTua.setNipIbu(txtNIPIbu.getText());

                    biodataOrangTuaManager.insert(biodataOrangTua, conn);

                    conn.commit();
                } catch (SQLException e) {
                    conn.rollback();
                    Logger.error(this, e.getMessage());
                    Logger.error(this, e.getStackTrace()[0].toString());

                    txtIDPeserta.setText("");
                    txtIdCalon.setText("");
                    txtIdAlamat.setText("");
                }
            } catch (SQLException ex) {
                Logger.error(this, ex.getMessage());

                txtIDPeserta.setText("");
                txtIdCalon.setText("");
                txtIdAlamat.setText("");
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtNIKPesertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIKPesertaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNIKPesertaKeyTyped

    private void txtJumlahAnakKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahAnakKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtJumlahAnakKeyTyped

    private void txtNISNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNISNKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNISNKeyTyped

    private void txtNoTeleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTeleponKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNoTeleponKeyTyped

    private void txtNoHpAyahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHpAyahKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNoHpAyahKeyTyped

    private void txtNoHpIbuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHpIbuKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNoHpIbuKeyTyped

    private void txtRtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRtKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRtKeyTyped

    private void txtRwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRwKeyReleased
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRwKeyReleased

    private void txtKodePosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodePosKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtKodePosKeyTyped
    private void btnKelolaBerkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelolaBerkasActionPerformed
        // TODO add your handling code here:
        Utils.openFrame(this, new FormBerkas(), true);
        dispose();  
    }//GEN-LAST:event_btnKelolaBerkasActionPerformed

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
            java.util.logging.Logger.getLogger(FormTambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTambahPeserta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKelolaBerkas;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private com.toedter.calendar.JCalendar calendarTglLahir;
    private javax.swing.JComboBox comboAgama;
    private javax.swing.JComboBox<String> comboJenisKelamin;
    private javax.swing.JComboBox comboProgramStudi;
    private javax.swing.JComboBox comboStatusAyah;
    private javax.swing.JComboBox comboStatusIbu;
    private javax.swing.JComboBox comboStatusPendaftaran;
    private javax.swing.JComboBox comboStatusPerkawinan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private com.toedter.calendar.JYearChooser numTahunDaftar;
    private com.toedter.calendar.JYearChooser numTahunLulusSD;
    private com.toedter.calendar.JYearChooser numTahunLulusSMA;
    private com.toedter.calendar.JYearChooser numTahunLulusSMP;
    private javax.swing.JTextPane txtAlamat;
    private javax.swing.JTextPane txtAlamatAyah;
    private javax.swing.JTextPane txtAlamatIbu;
    private javax.swing.JTextPane txtEmail;
    private javax.swing.JTextPane txtIDPeserta;
    private javax.swing.JTextPane txtIdAlamat;
    private javax.swing.JTextPane txtIdCalon;
    private javax.swing.JTextPane txtInstansiAyah;
    private javax.swing.JTextPane txtInstansiIbu;
    private javax.swing.JTextPane txtJabatanAyah;
    private javax.swing.JTextPane txtJabatanIbu;
    private javax.swing.JTextPane txtJumlahAnak;
    private javax.swing.JTextPane txtKabupaten;
    private javax.swing.JTextPane txtKecamatan;
    private javax.swing.JTextPane txtKodePos;
    private javax.swing.JTextPane txtNIKPeserta;
    private javax.swing.JTextPane txtNIPAyah;
    private javax.swing.JTextPane txtNIPIbu;
    private javax.swing.JTextPane txtNISN;
    private javax.swing.JTextPane txtNamaAyah;
    private javax.swing.JTextPane txtNamaIbu;
    private javax.swing.JTextField txtNamaKabupatenSD;
    private javax.swing.JTextField txtNamaKabupatenSMA;
    private javax.swing.JTextField txtNamaKabupatenSMP;
    private javax.swing.JTextPane txtNamaPeserta;
    private javax.swing.JTextField txtNamaProvinsiSD;
    private javax.swing.JTextField txtNamaProvinsiSMA;
    private javax.swing.JTextField txtNamaProvinsiSMP;
    private javax.swing.JTextField txtNamaSekolahSMA;
    private javax.swing.JTextField txtNamaSekolahSMP;
    private javax.swing.JTextField txtNamaSekolahSd;
    private javax.swing.JTextPane txtNoHpAyah;
    private javax.swing.JTextPane txtNoHpIbu;
    private javax.swing.JTextPane txtNoTelepon;
    private javax.swing.JTextPane txtPangkatAyah;
    private javax.swing.JTextPane txtPangkatIbu;
    private javax.swing.JTextPane txtPekerjaanAyah;
    private javax.swing.JTextPane txtPekerjaanIbu;
    private javax.swing.JTextPane txtPendidikanAyah;
    private javax.swing.JTextPane txtPendidikanIbu;
    private javax.swing.JTextPane txtProvinsi;
    private javax.swing.JTextPane txtRt;
    private javax.swing.JTextPane txtRw;
    private javax.swing.JTextPane txtTempatLahir;
    // End of variables declaration//GEN-END:variables
}
