package com.thymeleaf.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nama;
    private String nim;
    private String kelas;
    private String matakuliah;
    private Boolean hadir;

    public Siswa() {}

    public Siswa(int id, String nama, String nim, String kelas, String matakuliah, Boolean hadir) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.matakuliah = matakuliah;
        this.hadir = hadir;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getKelas() { return kelas; }
    public void setKelas(String kelas) { this.kelas = kelas; }

    public String getMatakuliah() { return matakuliah; }
    public void setMatakuliah(String matakuliah) { this.matakuliah = matakuliah; }

    public Boolean getHadir() { return hadir; }
    public void setHadir(Boolean hadir) { this.hadir = hadir; }
}