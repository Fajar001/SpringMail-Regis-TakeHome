package com.lawencon.app.mahasiswa.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.mahasiswa.dao.RegisDao;
import com.lawencon.app.mahasiswa.model.Registrasi;

@Repository("regis_repo_hibernate")
public class RegisDaoImpl extends BaseHibernate implements RegisDao{

	@Override
	public List<?> findAll() throws Exception {
		Query q = em.createQuery("from Registrasi where status like 'pending'");
		return q.getResultList();
	}

	@Override
	public String insert(Registrasi regis) throws Exception {
		em.persist(regis);
		return "OK";
	}

	@Override
	public Registrasi update(int id, String status) throws Exception {
		Query q = em.createQuery("from Registrasi where idRegis = :idParam");
		q.setParameter("idParam", id);
		Registrasi regis = new Registrasi();
		regis = (Registrasi) q.getSingleResult();
		regis.setIdRegis(id);
		regis.setStatus(status);
		em.merge(regis);
		return regis;
	}

	@Override
	public String delete(int id) throws Exception {
		Query q = em.createQuery("from Registrasi where idRegis = :idParam").
				setParameter("idParam", id);
		Registrasi regis = new Registrasi();
		regis = (Registrasi) q.getSingleResult();
		regis.setIdRegis(id);
		em.remove(regis);
		return "Deleted";
	}

	@Override
	public List<?> findAllStatus(String status) throws Exception {
		Query q = em.createQuery("from Registrasi where status = :statusParam");
		q.setParameter("statusParam", status);
		return q.getResultList();
	}
}
