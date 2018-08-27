package com.cpo.models;

public class Trainer {
	
	private int trainerId;
	private String trainerName;
	private int pokeballCount;
	private int candyCount;
	
	public Trainer() {
	}
	
	

	public Trainer(int trainerId, String trainerName, int pokeballCount, int candyCount) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.pokeballCount = pokeballCount;
		this.candyCount = candyCount;
	}



	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public int getPokeballCount() {
		return pokeballCount;
	}

	public void setPokeballCount(int pokeballCount) {
		this.pokeballCount = pokeballCount;
	}

	public int getCandyCount() {
		return candyCount;
	}

	public void setCandyCount(int candyCount) {
		this.candyCount = candyCount;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", pokeballCount=" + pokeballCount
				+ ", candyCount=" + candyCount + "]";
	}
}
