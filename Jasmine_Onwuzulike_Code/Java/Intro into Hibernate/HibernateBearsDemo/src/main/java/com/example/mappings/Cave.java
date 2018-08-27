package com.example.mappings;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="CAVE")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Cave {
	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(sequenceName="CAVE_SEQ", name="CAVE_SEQ")
	@GeneratedValue(generator="CAVE_SEQ", strategy=GenerationType.SEQUENCE)
	private int caveId;
	
	@OneToMany(mappedBy="dwelling", fetch=FetchType.EAGER)
	private Set<Bear> residents = new HashSet<Bear>();
	
	@Column(name="SQ_FOOTAGE")
	private double squareFootage;
	
	@Column(name="CAVE_TYPE")
	private String caveType;
	
	public int getCaveId() {
		return caveId;
	}
	public void setCaveId(int caveId) {
		this.caveId = caveId;
	}
	public Set<Bear> getResidents() {
		return residents;
	}
	public void setResidents(Set<Bear> residents) {
		this.residents = residents;
	}
	public double getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getCaveType() {
		return caveType;
	}
	public void setCaveType(String caveType) {
		this.caveType = caveType;
	}
	@Override
	public String toString() {
		return "Cave [caveId=" + caveId +  " squareFootage=" + squareFootage + ", caveType="
				+ caveType + "]";
	}
	public Cave(double squareFootage, String caveType) {
		super();
		this.squareFootage = squareFootage;
		this.caveType = caveType;
	}
	public Cave() {
		super();
	}

}
