package com.lawencon.app.mahasiswa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.mahasiswa.dao.RegisDao;
import com.lawencon.app.mahasiswa.model.Registrasi;
import com.lawencon.app.mahasiswa.service.RegisService;

@Service
@Transactional
public class RegisServiceImpl implements RegisService {

	@Autowired
	@Qualifier("regis_repo_hibernate")
	private RegisDao regisDao;

	@Autowired
	private JavaMailSender javaMail;

	@Override
	public List<?> findAll() throws Exception {
		return regisDao.findAll();
	}

	@Override
	public List<?> findAllStatus(String status) throws Exception {
		return regisDao.findAllStatus(status);
	}

	@Override
	public String insert(Registrasi regis) throws Exception {
		return regisDao.insert(regis);
	}

	@Override
	public Registrasi update(int id, String status) throws Exception {
		return regisDao.update(id, status);
	}

	@Override
	public String delete(int id) throws Exception {
		return regisDao.delete(id);
	}

	@Override
	public String sendMail(Registrasi regis) throws Exception {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(regis.getEmail());
		msg.setSubject("Registration");
		msg.setText("Thank you for your registration");
		javaMail.send(msg);
		return "Ok";
	}

	@Override
	public String sendMailOption(Registrasi regis) throws Exception {
		SimpleMailMessage msg = new SimpleMailMessage();
		if(regis.getStatus().equals("approve")) {
			msg.setTo(regis.getEmail());
			msg.setSubject("Registration Approved");
			msg.setText("Congratulation, you are approved");
			javaMail.send(msg);
		}
		else if(regis.getStatus().equals("reject")) {
			msg.setTo(regis.getEmail());
			msg.setSubject("Registration Denied");
			msg.setText("Sorry, you can try again later");
			javaMail.send(msg);
		}
		return "OK";
	}
}
