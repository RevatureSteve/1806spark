package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	@Column
	private int t_id;
	@Column
	private int u_id;
	@Column
	private String t_name;
	private int ts_id;

	public Task() {
	}

	public Task(int id, int u_id, String t_name, int ts_id) {
		super();
		this.t_id = id;
		this.u_id = u_id;
		this.t_name = t_name;
		this.ts_id = ts_id;
	}

	public int getId() {
		return t_id;
	}

	public void setId(int id) {
		this.t_id = id;
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
		return "Task [id=" + t_id + ", u_id=" + u_id + ", t_name=" + t_name + ", ts_id=" + ts_id + "]";
	}

}
