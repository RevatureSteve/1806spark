package com.revature.domain;

public class Decision {
	private int rq_statusId;
	private int rId;
	private int mgrId;
	public int getRq_statusId() {
		return rq_statusId;
	}
	public void setRq_statusId(int rq_statusId) {
		this.rq_statusId = rq_statusId;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getMgrId() {
		return mgrId;
	}
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	public Decision(int rq_statusId, int rId, int mgrId) {
		super();
		this.rq_statusId = rq_statusId;
		this.rId = rId;
		this.mgrId = mgrId;
	}
	@Override
	public String toString() {
		return "Decision [rq_statusId=" + rq_statusId + ", rId=" + rId + ", mgrId=" + mgrId + "]";
	}
	
	
}
