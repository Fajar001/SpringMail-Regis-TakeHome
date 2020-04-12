package com.lawencon.app.mahasiswa.dao;

import java.util.List;

import com.lawencon.app.mahasiswa.model.Login;

public interface LoginDao {
	abstract List<Login> findAll() throws Exception;
	abstract Login findUsername(Login login) throws Exception;
	abstract Login validUser(String user, String pass) throws Exception;
	abstract String insertUser(Login login) throws Exception;
	abstract Login update(int id, String user, String pass, String role) throws Exception;
	abstract String deleteById(int id) throws Exception;
}
