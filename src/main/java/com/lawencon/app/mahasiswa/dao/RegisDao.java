package com.lawencon.app.mahasiswa.dao;

import java.util.List;

import com.lawencon.app.mahasiswa.model.Registrasi;

public interface RegisDao {
	abstract List<?> findAll()throws Exception;
	abstract List<?> findAllStatus(String status)throws Exception;
	abstract String insert(Registrasi regis)throws Exception;
	abstract Registrasi update(int id, String status)throws Exception;
	abstract String delete(int id)throws Exception;
}
