package com.revature.threads;

import java.io.IOException;

import com.revature.dao.LabelDao;
import com.revature.labels.LabelC;

public class SaveFilesThread implements Runnable {
	
	private LabelC label;
	
	

	public SaveFilesThread() {
		super();
	}
	
	public SaveFilesThread(LabelC label) {
		super();
		this.label = label;
	}

	@Override
	public void run() {
		// Save object
		System.out.println("\t\t New thread strarted");
		try {
			LabelDao.saveLabel(label);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Save objet.toString()

		try {
			LabelDao.saveLabelBuffer(label);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\t\t Label saved");
	}

	public LabelC getLabel() {
		return label;
	}

	public void setLabel(LabelC label) {
		this.label = label;
	}
	
	

}
