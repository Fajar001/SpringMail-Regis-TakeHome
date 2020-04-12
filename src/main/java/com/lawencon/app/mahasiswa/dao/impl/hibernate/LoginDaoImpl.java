package com.lawencon.app.mahasiswa.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.mahasiswa.dao.LoginDao;
import com.lawencon.app.mahasiswa.model.Login;

@Repository("login_repo_hibernate")
public class LoginDaoImpl extends BaseHibernate implements LoginDao{

	@Override
	public Login validUser(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Login where username = : userParam and password = :passParam")
		.setParameter("userParam", user)
		.setParameter("passParam", pass);
		return (Login) q.getSingleResult();
	}

	@Override
	public String insertUser(Login login) throws Exception {
		// TODO Auto-generated method stub
		em.persist(login);
		return "Succsess to insert";
	}

	@Override
	public Login update(int id, String user, String pass, String role) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Login where idLogin = :idParam");
		q.setParameter("idParam", id);
		Login log = new Login();
		log = (Login) q.getSingleResult();
		log.setUsername(user);
		log.setPassword(pass);
		log.setRole(role);
		em.merge(log);
		return log;
	}

	@Override
	public String deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Login where idLogin = :idParam");
		q.setParameter("idParam", id);
		Login log = new Login();
		log = (Login) q.getSingleResult();
		log.setIdLogin(id);
		em.remove(log);
		return "[USERNAME] AND [PASSWORD] DELETED...";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Login> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Login");
		return q.getResultList();
	}

}
