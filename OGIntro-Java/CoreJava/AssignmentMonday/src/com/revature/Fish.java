package com.revature;

public abstract class Fish { // can i change this into an interface from a class?
	
	public abstract void splash (); //ABSTRACT METHOD any class that extends Fish must implement splash

		private Boolean canSwim;
		private Boolean HasScales;
		@Override
		public String toString() {
			return "Fish [canSwim=" + canSwim + ", HasScales=" + HasScales + "]";
		}
		public Boolean getCanSwim() {
			return canSwim;
		}
		public void setCanSwim(Boolean canSwim) {
			this.canSwim = canSwim;
		}
		public Boolean getHasScales() {
			return HasScales;
		}
		public void setHasScales(Boolean hasScales) {
			HasScales = hasScales;
		}
	
		
}
