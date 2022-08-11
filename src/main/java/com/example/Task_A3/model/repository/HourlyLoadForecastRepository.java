package com.example.Task_A3.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Task_A3.model.entity.HourlyLoadForecast;

@Repository
public interface HourlyLoadForecastRepository extends JpaRepository<HourlyLoadForecast, Integer>{
	
	List<HourlyLoadForecast> getHourlyLoadForecastByDate(Date date);
	
	@Query(value = "SELECT SUM(electricityGeneration) FROM HourlyLoadForecast")
	public double sumElectricityGeneration();
	
	@Query(value = "SELECT SUM(conventional) FROM HourlyLoadForecast")
	public double sumConventional();
	
	@Query(value = "SELECT SUM(total) FROM HourlyLoadForecast")
	public double sumTotalForDay();

}
