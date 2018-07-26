package bank;

public abstract class pin {

		private int pin;

		public pin() {
		}

		public pin(int pin) {
			super();
			this.pin = pin;
		}

		public int getPin() {
			return pin;
		}

		public void setPin(int pin) {
			this.pin = pin;
		}
		
		public abstract void pinNum();
		
	}
