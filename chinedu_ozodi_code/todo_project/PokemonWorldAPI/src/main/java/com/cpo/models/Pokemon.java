package com.cpo.models;

import java.io.Serializable;

public class Pokemon implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int pokeId;
	private String name;
	private int experience;
	private int height;
	private String imageUrl;
	private int statusId;
	private String status;
	private int trainerId;
	private int ltId;

	public Pokemon() {
	}

	public Pokemon(int id, int pokeId, String name, int experience, int height, String imageUrl, int statusId,
			String status, int trainerId, int ltId) {
		super();
		this.id = id;
		this.pokeId = pokeId;
		this.name = name;
		this.experience = experience;
		this.height = height;
		this.imageUrl = imageUrl;
		this.statusId = statusId;
		this.status = status;
		this.trainerId = trainerId;
		this.ltId = ltId;
	}
	
	public Pokemon(int pokeId, String name, int experience, int height, String imageUrl) {
		super();
		this.pokeId = pokeId;
		this.name = name;
		this.experience = experience;
		this.height = height;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPokeId() {
		return pokeId;
	}

	public void setPokeId(int pokeId) {
		this.pokeId = pokeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getLtId() {
		return ltId;
	}

	public void setLtId(int ltId) {
		this.ltId = ltId;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", pokeId=" + pokeId + ", name=" + name + ", experience=" + experience
				+ ", height=" + height + ", imageUrl=" + imageUrl + ", statusId=" + statusId + ", status=" + status
				+ ", trainerId=" + trainerId + ", ltId=" + ltId + "]";
	}
	

}
