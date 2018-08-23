package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class Todo {
	
	@Id
	@Column(name="t_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="task_seq")
	@SequenceGenerator(name="task_seq", sequenceName="task_seq")
	private int t_id;
	
	@Column(name="u_id")
	private int u_id;
	
	@Column(name="t_name")
	private String t_name;
	
	@Column(name="ts_id")
	private int ts_id;

	
	public Todo() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param u_id
	 * @param t_name
	 * @param ts_id
	 */
	public Todo(int u_id, String t_name, int ts_id) {
		super();
		this.t_id = u_id;
		this.t_name = t_name;
		this.ts_id = ts_id;
	}


	/**
	 * @param id
	 * @param u_id
	 * @param t_name
	 * @param ts_id
	 */
	public Todo(int id, int u_id, String t_name, int ts_id) {
		super();
		this.t_id = t_id;
		this.u_id = u_id;
		this.t_name = t_name;
		this.ts_id = ts_id;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return t_id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.t_id = t_id;
	}


	/**
	 * @return the u_id
	 */
	public int getU_id() {
		return u_id;
	}


	/**
	 * @param u_id the u_id to set
	 */
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}


	/**
	 * @return the t_name
	 */
	public String getT_name() {
		return t_name;
	}


	/**
	 * @param t_name the t_name to set
	 */
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}


	/**
	 * @return the ts_id
	 */
	public int getTs_id() {
		return ts_id;
	}


	/**
	 * @param ts_id the ts_id to set
	 */
	public void setTs_id(int ts_id) {
		this.ts_id = ts_id;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Todo [t_id=" + t_id + ", u_id=" + u_id + ", t_name=" + t_name + ", ts_id=" + ts_id + "]";
	}

	
}
