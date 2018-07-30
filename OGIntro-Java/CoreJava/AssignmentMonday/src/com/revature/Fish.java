package com.revature;

import java.io.Serializable;

public abstract class Fish implements Serializable { // can i change this into an interface from a class?
	
	
		private static final long serialVersionUID = 7979;
		private Boolean canSwim;
		private Boolean HasScales;
		@Override
		public String toString() {
			return "Fish [canSwim=" + getCanSwim() + ", HasScales=" + HasScales + "]";
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
		public Fish(Boolean canSwim, Boolean hasScales) {
			super();
			this.setCanSwim(canSwim);
			HasScales = hasScales;
		}
		public Fish() {
			super();
		}
	
	
}
