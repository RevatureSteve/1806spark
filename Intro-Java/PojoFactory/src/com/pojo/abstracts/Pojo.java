package com.pojo.abstracts;

public class Pojo {

		public String modelNumber;
		private int numberOfWheels;
		private boolean isActive;

		public Pojo() {
			this.modelNumber = "Unnamed Vehicle";
			System.out.println("90J0 MACHINE: ACTIVE");
		};

		public Pojo(String modelNumber, int numberOfWheels, boolean isActive) {
			super();
			this.modelNumber = modelNumber;
			this.numberOfWheels = numberOfWheels;
			this.isActive = isActive;
		}

		public int getNumberOfWheels() {
			return numberOfWheels;
		}

		public void setNumberOfWheels(int numberOfWheels) {
			this.numberOfWheels = numberOfWheels;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		@Override
		public String toString() {
			return "Pojo [modelNumber=" + modelNumber + ", numberOfWheels=" + numberOfWheels + ", isActive=" + isActive
					+ "]";
		};

		
};