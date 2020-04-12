package com.lawencon.app.mahasiswa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "mahasiswa")
public class Registrasi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegis;
	
	private String noKTP;
	private String email;
	private String nama;
	private String alamat;
	private String noTelp;
	private String namaOrangTua;
	private String namaAsalSekolah;
	private String alamatAsalSekolah;
	private int nilaiMTK, nilaiBahasaIndo, nilaiBahasaInggris, nilaiMIPA;
	private String status;
	public int getIdRegis() {
		return idRegis;
	}
	public void setIdRegis(int idRegis) {
		this.idRegis = idRegis;
	}
	public String getNoKTP() {
		return noKTP;
	}
	public void setNoKTP(String noKTP) {
		this.noKTP = noKTP;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNoTelp() {
		return noTelp;
	}
	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}
	public String getNamaOrangTua() {
		return namaOrangTua;
	}
	public void setNamaOrangTua(String namaOrangTua) {
		this.namaOrangTua = namaOrangTua;
	}
	public String getNamaAsalSekolah() {
		return namaAsalSekolah;
	}
	public void setNamaAsalSekolah(String namaAsalSekolah) {
		this.namaAsalSekolah = namaAsalSekolah;
	}
	public String getAlamatAsalSekolah() {
		return alamatAsalSekolah;
	}
	public void setAlamatAsalSekolah(String alamatAsalSekolah) {
		this.alamatAsalSekolah = alamatAsalSekolah;
	}
	public int getNilaiMTK() {
		return nilaiMTK;
	}
	public void setNilaiMTK(int nilaiMTK) {
		this.nilaiMTK = nilaiMTK;
	}
	public int getNilaiBahasaIndo() {
		return nilaiBahasaIndo;
	}
	public void setNilaiBahasaIndo(int nilaiBahasaIndo) {
		this.nilaiBahasaIndo = nilaiBahasaIndo;
	}
	public int getNilaiBahasaInggris() {
		return nilaiBahasaInggris;
	}
	public void setNilaiBahasaInggris(int nilaiBahasaInggris) {
		this.nilaiBahasaInggris = nilaiBahasaInggris;
	}
	public int getNilaiMIPA() {
		return nilaiMIPA;
	}
	public void setNilaiMIPA(int nilaiMIPA) {
		this.nilaiMIPA = nilaiMIPA;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
