package com.revature.service;

import java.util.List;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.model.FlashCard;

public class AppServiceImpl implements AppService {

	FlashCardDao dao = new FlashCardDaoImpl();
	
	@Override
	public void saveFlashCard(FlashCard fc) {
	}

	@Override
	public List<FlashCard> findAll() {
		return dao.findAll();
	}
	
	
	@Override
	public FlashCard getFlashCardById(int id) {
		return null;
	}
}
