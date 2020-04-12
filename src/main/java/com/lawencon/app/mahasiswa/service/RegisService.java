package com.lawencon.app.mahasiswa.service;

import java.util.List;

import com.lawencon.app.mahasiswa.model.Registrasi;

public interface RegisService {
	abstract List<?> findAll()throws Exception;
	abstract List<?> findById(int id) throws Exception;
	abstract List<?> findAllStatus(String status)throws Exception;
	abstract String insert(Registrasi regis)throws Exception;
	abstract Registrasi update(int id, String status)throws Exception;
	abstract String delete(int id)throws Exception;
	abstract String sendMail(Registrasi regis)throws Exception;
	abstract String sendMailOption(Registrasi regis)throws Exception;
}
