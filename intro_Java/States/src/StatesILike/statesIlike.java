package StatesILike;

// State, Behavior, NO ARG Const., and ovrd toString

public class statesIlike {

	 private String name;
	 private int population;
	 public int timesVisited;
	
	 
	 public statesIlike() {}
	 
	 public statesIlike(String name, int population, int timesVisited) {
		super();
		this.name = name;
		this.population = population;
		this.timesVisited = timesVisited;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPopulation() {
		return population;
	}


	public void setPopulation(int population) {
		this.population = population;
	}


	public int getTimesVisited() {
		return timesVisited;
	}


	public void setTimesVisited(int timesVisited) {
		this.timesVisited = timesVisited;
	}


	@Override
	public String toString() {
		return "statesIlike [name=" + name + ", population=" + population + ", timesVisited=" + timesVisited + "]";
	}
	 
	
	 
}
