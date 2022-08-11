package com.example.Task_A3.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.Task_A3.model.entity.HourlyLoadForecast;

public interface HourlyLoadForecastService {
	
	List<HourlyLoadForecast> getForecastForToday(Date today, Sort sort);

}
