package com.lawencon.app.mahasiswa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.mahasiswa.dao.LoginDao;
import com.lawencon.app.mahasiswa.model.Login;
import com.lawencon.app.mahasiswa.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	@Qualifier("login_repo_hibernate")
	private LoginDao loginDao;
	
	@Override
	public List<Login> findAll() throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findAll();
	}

	@Override
	public Boolean validUser(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		Login log = null;
		try {
			log = loginDao.validUser(user, pass);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(log != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String insertUser(Login login) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.insertUser(login);
	}

	@Override
	public String update(int id, String user, String pass, String role) throws Exception {
		// TODO Auto-generated method stub
		loginDao.update(id, user, pass, role);
		return "Failed...";
	}

	@Override
	public String deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.deleteById(id);
	}
}
