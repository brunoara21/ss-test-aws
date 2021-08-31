package com.ss.testing_aws.controller.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ss.testing_aws.controller.dto.CreateRestaurantDto;
import com.ss.testing_aws.dao.RestaurantRepository;
import com.ss.testing_aws.entity.Restaurant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantService {

	private RestaurantRepository restaurantRepository;
	
	@Transactional
	public Restaurant createNewRestaurant(@Valid @RequestBody CreateRestaurantDto createRestaurantDto) {
		
		Restaurant restaurant = Restaurant.builder()
				.name(createRestaurantDto.getName())
				.build();
		
		restaurantRepository.save(restaurant);
		
		return restaurant;
	}

	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants;
	}


}
