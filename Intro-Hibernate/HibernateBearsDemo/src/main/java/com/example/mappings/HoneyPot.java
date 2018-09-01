package com.example.mappings;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQueries({
	@NamedQuery(name="getAllHoneypots", query = "FROM com.example.mappings.HoneyPot")
})

@NamedNativeQueries({
	@NamedNativeQuery(name="getSmallHoneypots", 
			query = "SELECT * FROM Honeypot WHERE volume < :maxSizeToBeConsideredSmall",
			resultClass=HoneyPot.class)
})

@Entity
@Table(name="HONEYPOT")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class HoneyPot {

	@Id
	@Column(name="HONEYPOT_ID")
	@SequenceGenerator(name="HONEYPOT_SEQ", sequenceName="HONEYPOT_SEQ")
	@GeneratedValue(generator="HONEYPOT_SEQ", strategy=GenerationType.SEQUENCE)
	private int honeypotId;
	
	@Column
	private double volume;
	@Column(name="HONEY_AMOUNT")
	private double honeyAmount;
	
	public int getHoneypotId() {
		return honeypotId;
	}
	public void setHoneypotId(int honeypotId) {
		this.honeypotId = honeypotId;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getHoneyAmount() {
		return honeyAmount;
	}
	public void setHoneyAmount(double honeyAmount) {
		this.honeyAmount = honeyAmount;
	}
	public HoneyPot(double volume, double honeyAmount) {
		super();
		this.volume = volume;
		this.honeyAmount = honeyAmount;
	}
	public HoneyPot() {
		super();
	}
	@Override
	public String toString() {
		return "HoneyPot [volume=" + volume + ", honeyAmount=" + honeyAmount + "]";
	}

}
