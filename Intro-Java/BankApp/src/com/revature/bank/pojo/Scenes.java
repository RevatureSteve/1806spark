package com.revature.bank.pojo;

public class Scenes {
	private boolean viewBalanceScene;
	private boolean negativeScene;
	
	public Scenes() {
		super();
		this.viewBalanceScene = false;
		this.negativeScene = false;
	}

	public boolean isViewBalanceScene() {
		return viewBalanceScene;
	}

	public void setViewBalanceScene(boolean viewBalanceScene) {
		this.viewBalanceScene = viewBalanceScene;
	}

	public boolean isNegativeScene() {
		return negativeScene;
	}

	public void setNegativeScene(boolean negativeScene) {
		this.negativeScene = negativeScene;
	}
}
