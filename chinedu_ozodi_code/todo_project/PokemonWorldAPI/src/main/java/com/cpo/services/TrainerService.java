package com.cpo.services;

import java.util.List;

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
	
	public List<Trainer> getAllTrainers() {
		return TrainerDatabaseDao.getInstance().getAllTrainers();
	}

	public Trainer getTrainerById(int id) {
		return TrainerDatabaseDao.getInstance().getTrainerById(id);
	}
	
	public int updateTrainer(Trainer trainer) {
		return TrainerDatabaseDao.getInstance().updateTrainer(trainer);
	}

}
