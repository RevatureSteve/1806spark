package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {

	@Id // PK
	@Column(name = "T_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="task_seq")
	@SequenceGenerator(name="task_seq", sequenceName="task_seq")
	private int t_Id;

	@Column(name = "U_ID")
	private int u_Id;

	@Column(name = "T_NAME")
	private String t_Name;

	@Column(name = "TS_ID")
	private int ts_Id;

	public Task() {

	}

	public Task(int t_Id, int u_Id, String t_Name, int ts_Id) {
		super();
		this.t_Id = t_Id;
		this.u_Id = u_Id;
		this.t_Name = t_Name;
		this.ts_Id = ts_Id;
	}

	public int getT_Id() {
		return t_Id;
	}

	public void setT_Id(int t_Id) {
		this.t_Id = t_Id;
	}

	public int getU_Id() {
		return u_Id;
	}

	public void setU_Id(int u_Id) {
		this.u_Id = u_Id;
	}

	public String getT_Name() {
		return t_Name;
	}

	public void setT_Name(String t_Name) {
		this.t_Name = t_Name;
	}

	public int getTs_Id() {
		return ts_Id;
	}

	public void setTs_Id(int ts_Id) {
		this.ts_Id = ts_Id;
	}

	@Override
	public String toString() {
		return "Task [t_Id=" + t_Id + ", u_Id=" + u_Id + ", t_Name=" + t_Name + ", ts_Id=" + ts_Id + "]";
	}

}
