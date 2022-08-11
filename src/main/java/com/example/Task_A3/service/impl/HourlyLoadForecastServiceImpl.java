package com.example.Task_A3.service.impl;

import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Task_A3.model.entity.HourlyLoadForecast;
import com.example.Task_A3.model.repository.HourlyLoadForecastRepository;
import com.example.Task_A3.service.HourlyLoadForecastService;

@Service
public class HourlyLoadForecastServiceImpl implements HourlyLoadForecastService {
	
	private final HourlyLoadForecastRepository hourlyLoadForecastRepository;
	
	@Autowired
	public HourlyLoadForecastServiceImpl(HourlyLoadForecastRepository hourlyLoadForecastRepository) {
		this.hourlyLoadForecastRepository = hourlyLoadForecastRepository;
	}
	
	@Override
	public List<HourlyLoadForecast> getForecastForToday(Date today, Sort sort) {
		today = new Date();
		
		List<HourlyLoadForecast> forecastForToday = new ArrayList<>();
		
		for(HourlyLoadForecast forecast : hourlyLoadForecastRepository.findAll()) {
			
			if(TimeUnit.MILLISECONDS.toDays(today.getTime()) - TimeUnit.MILLISECONDS.toDays(forecast.getDate().getTime()) == 1) {
				forecastForToday.add(forecast);
			}
		}
		
		return forecastForToday;
	}
	

}
