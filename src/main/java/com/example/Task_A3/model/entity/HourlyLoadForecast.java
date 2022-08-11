package com.example.Task_A3.model.entity;

import org.hibernate.annotations.Formula;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hourly_load_forecast")
public class HourlyLoadForecast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "date")
	private Date date;
	
	@Column(name = "start_time")
	private Date startTime;
	@Column(name = "end_time")
	private Date endTime;
	
	@Column(name = "electricity_generation")
	private Double electricityGeneration;
	@Column(name = "conventional")
	private Double conventional;

	@Column
	@Formula("electricity_generation + conventional")
	private Double total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Double getElectricityGeneration() {
		return electricityGeneration;
	}
	public void setElectricityGeneration(Double electricityGeneration) {
		this.electricityGeneration = electricityGeneration;
	}
	
	public Double getConventional() {
		return conventional;
	}
	public void setConventional(Double conventional) {
		this.conventional = conventional;
	}

	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
