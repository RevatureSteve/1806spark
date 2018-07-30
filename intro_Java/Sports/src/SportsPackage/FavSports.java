package SportsPackage;

/**
 * State, Behavior, no args, override toString
 * @author tyler
 *
 */
public class FavSports {
	private String name;
	private int rank;
	public boolean isAwesome;
	
	public FavSports() {}
	
	public FavSports(String name, int rank, boolean isAwesome) {
		super();
		this.name = name;
		this.rank = rank;
		this.isAwesome = isAwesome;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public boolean isAwesome() {
		return isAwesome;
	}


	public void setAwesome(boolean isAwesome) {
		this.isAwesome = isAwesome;
	}

	@Override
	public String toString() {
		return "FavSports [name=" + name + ", rank=" + rank + ", isAwesome=" + isAwesome + "]";
	}


	
	
	
	

	
}

