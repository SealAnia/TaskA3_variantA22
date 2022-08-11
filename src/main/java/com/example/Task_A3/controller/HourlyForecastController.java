package com.example.Task_A3.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Task_A3.model.repository.HourlyLoadForecastRepository;
import com.example.Task_A3.service.impl.HourlyLoadForecastServiceImpl;

@Controller
public class HourlyForecastController {
	
	private final HourlyLoadForecastServiceImpl service;
	
	private final HourlyLoadForecastRepository repository;
	
	@Autowired
	public HourlyForecastController(HourlyLoadForecastServiceImpl service, HourlyLoadForecastRepository repository) {
		this.service = service;
		
		this.repository = repository;
	}
	
	@GetMapping(value = "/hourly_load_forecast")
	public String getHourlyLoadForecast(Model model) {
		Date today = new Date();
		var forecast = service.getForecastForToday(today, Sort.by(Direction.ASC, "startTime")); 
		model.addAttribute("forecast", forecast);
		
		var generation = repository.sumElectricityGeneration();
		model.addAttribute("generation", generation);
		
		var conventional = repository.sumConventional();
		model.addAttribute("conventional", conventional);
		
		var totalForDay = repository.sumTotalForDay();
		model.addAttribute("totalForDay", totalForDay);
		
		return "hour_forecast";
	}

}
