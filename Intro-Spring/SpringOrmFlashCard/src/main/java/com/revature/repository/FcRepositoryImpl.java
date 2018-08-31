package com.revature.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.FlashCard;

@Repository
public class FcRepositoryImpl implements FcRepository {

	//get the SessionFactory by DI
	@Autowired
	private SessionFactory sf;
	
	@Override
	public void saveFc(FlashCard fc) {
		Session session = sf.getCurrentSession();
		session.save(fc);
	}

	@Override
	public List<FlashCard> findAllFlashCards() {
		Session session = sf.getCurrentSession();
		return session.createCriteria(FlashCard.class).list();
	}
	
	

	
	
}
