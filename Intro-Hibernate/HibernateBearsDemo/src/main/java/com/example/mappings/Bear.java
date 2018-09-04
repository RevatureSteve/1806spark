package com.example.mappings;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="BEAR")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Bear {
	
	@Id
	@Column(name="BEAR_ID")
	@SequenceGenerator(sequenceName="BEAR_SEQ", name="BEAR_SEQ")
	@GeneratedValue(generator="BEAR_SEQ", 
		strategy=GenerationType.SEQUENCE)
	private int bearId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="BEAR_HOME")
	private Cave dwelling;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HONEYPOT_ID")
	private HoneyPot honeyPot;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PARENT_CUB", 
		joinColumns=@JoinColumn(name="BEAR_ID"), 
		inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private Set<Bear> bearCubs;
	
	@Column(name="BEAR_COLOR")
	private String bearColor;
	@Column
	private String breed;
	private double weight;
	private double height;
	public int getBearId() {
		return bearId;
	}
	public void setBearId(int bearId) {
		this.bearId = bearId;
	}
	public Cave getDwelling() {
		return dwelling;
	}
	public void setDwelling(Cave dwelling) {
		this.dwelling = dwelling;
	}
	public HoneyPot getHoneyPot() {
		return honeyPot;
	}
	public void setHoneyPot(HoneyPot honeyPot) {
		this.honeyPot = honeyPot;
	}
	public Set<Bear> getBearCubs() {
		return bearCubs;
	}
	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}
	public String getBearColor() {
		return bearColor;
	}
	public void setBearColor(String bearColor) {
		this.bearColor = bearColor;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
//	@Override
//	public String toString() {
//		return "Bear [bearId=" + bearId + ", dwelling=" + dwelling + ", honeyPot=" + honeyPot + ", bearCubs=" + bearCubs
//				+ ", bearColor=" + bearColor + ", breed=" + breed + ", weight=" + weight + ", height=" + height + "]";
//	}
	
	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", bearColor=" + bearColor + ", breed=" + breed + ", weight=" + weight
				+ ", height=" + height + "]";
	}
	
	public Bear(Cave dwelling, HoneyPot honeyPot, String bearColor, String breed,
			double weight, double height) {
		super();
		this.bearCubs = new HashSet<Bear>();
		this.dwelling = dwelling;
		this.honeyPot = honeyPot;
		this.bearColor = bearColor;
		this.breed = breed;
		this.weight = weight;
		this.height = height;
	}
	public Bear() {
		super();
		this.bearCubs = new HashSet<Bear>();
	}

	
	
}
