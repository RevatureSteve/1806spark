package com.revature.javaAssignment1.dao;

public class NewThread implements Runnable{
	
	private static String fileNameAndPath = "src/com/revature/javaAssignment1/MusicListBufferedWriter.txt";

	private Object c;
	
	public NewThread() {
		super();
	}

	
	@Override
	public void run() {
		MusicDao.writeToFile(fileNameAndPath, c);
		MusicDao.WriteSerializeMusicObject(c);
	}


	public NewThread(Object c) {
		super();
		this.c = c;
	}
	
	
	

}
