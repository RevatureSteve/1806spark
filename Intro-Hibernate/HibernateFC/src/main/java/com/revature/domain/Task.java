package com.revature.domain;

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

	@Id
	@Column(name = "T_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
	@SequenceGenerator(name = "task_seq", sequenceName = "task_seq")
	private int t_id;

	@Column(name = "U_ID")
	private int u_id;
	
	@Column(name = "T_NAME", unique=true)
	private String t_name;
	
	@Column(name = "TS_ID")
	private int ts_id;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getTs_id() {
		return ts_id;
	}

	public void setTs_id(int ts_id) {
		this.ts_id = ts_id;
	}

	@Override
	public String toString() {
		return "Task [t_id=" + t_id + ", u_id=" + u_id + ", t_name=" + t_name + ", ts_id=" + ts_id + "]";
	}

	
}
