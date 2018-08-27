package com.cpo.dao;

import com.cpo.models.Trainer;

public interface TrainerDao {

	int createTrainer(Trainer trainer);

	Trainer getTrainerById(int id);

}
