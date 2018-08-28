package com.cpo.dao;

import java.util.List;

import com.cpo.models.Trainer;

public interface TrainerDao {

	int createTrainer(Trainer trainer);

	Trainer getTrainerById(int id);

	List<Trainer> getAllTrainers();

	int updateTrainer(Trainer trainer);

}
