package com.revature.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.labels.LabelA;
import com.revature.labels.LabelC;

public class LabelDao {
	
	private static String filePathAndName = "src/com/revature/object_save";
	private static String bufferedFilePathAndName = "src/com/revature/text_save.txt";
	
	
	public static void saveLabel(LabelA label) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(filePathAndName));
		
		oos.writeObject(label);
		oos.close();
	}
	
	public static LabelA loadLabel() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream(filePathAndName));
		LabelA label = (LabelA) ois.readObject();
		ois.close();
		return label;
	}
	
	public static void saveLabelBuffer( LabelC label) throws IOException {
		BufferedWriter bw = new BufferedWriter( new FileWriter(bufferedFilePathAndName));
		bw.write(label.toString());
		bw.close();
	}
	
	public static String loadLabelBuffer() throws IOException {
		BufferedReader br = new BufferedReader( new FileReader(bufferedFilePathAndName));
		
		String string = br.readLine();
		
		br.close();
		return string;
	}

}
