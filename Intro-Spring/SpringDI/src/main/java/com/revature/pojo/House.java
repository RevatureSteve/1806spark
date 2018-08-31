package com.revature.pojo;

import org.springframework.beans.factory.annotation.Qualifier;

//@Component
public class House {

	private String name = "my awsome house";
	
	@Qualifier(value="hello World")
//	@Autowired
	private String wallColor;
	private int numOfWalls;
	
	
	private Wall wall;
	
	public House() {}
	

	public House(String wallColor) {
		System.out.println("Constructor DI");
		this.wallColor = wallColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWallColor() {
		return wallColor;
	}

	public void setWallColor(String wallColor) {
		this.wallColor = wallColor;
	}

	public int getNumOfWalls() {
		return numOfWalls;
	}

	public void setNumOfWalls(int numOfWalls) {
		System.out.println("#ofWalls Setter DI");
		this.numOfWalls = numOfWalls;
	}
	
	public Wall getWall() {
		return wall;
	}

	public void setWall(Wall wall) {
		System.out.println("Wall Setter DI");
		this.wall = wall;
	}


	@Override
	public String toString() {
		return "House [name=" + name + ", wallColor=" + wallColor + ", numOfWalls=" + numOfWalls + ", wall=" + wall
				+ "]";
	}

}
