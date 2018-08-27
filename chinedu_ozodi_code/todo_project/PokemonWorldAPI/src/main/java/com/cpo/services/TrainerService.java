package com.cpo.services;

import com.cpo.dao.TrainerDatabaseDao;
import com.cpo.models.Trainer;

public class TrainerService {
	
	private static TrainerService instance;

	private TrainerService() {
		super();
	}

	public static TrainerService getInstance() {
		if (instance == null) {
			instance = new TrainerService();
		}
		return instance;
	}
	
	public int createTrainer(Trainer trainer) {
		return TrainerDatabaseDao.getInstance().createTrainer(trainer);
	}
	
	public Trainer getTrainerById(int id) {
		return TrainerDatabaseDao.getInstance().getTrainerById(id);
	}
	

}
