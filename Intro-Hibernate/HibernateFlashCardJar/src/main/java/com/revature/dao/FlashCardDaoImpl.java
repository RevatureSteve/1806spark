package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.FlashCard;
import com.revature.util.HibernateUtil;

public class FlashCardDaoImpl implements FlashCardDao {

	public void createFlashCard(FlashCard fc) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(fc); // save = insert in hibernate
		tx.commit();
		session.close();
	}

	public FlashCard getFlashCardById(int id) {
		Session session = HibernateUtil.getSession();
		FlashCard fc = (FlashCard) session.get(FlashCard.class, id);
		session.close();
		return fc;
	}

	public List<FlashCard> getAllFlashCards() {
		return null;
	}

}
