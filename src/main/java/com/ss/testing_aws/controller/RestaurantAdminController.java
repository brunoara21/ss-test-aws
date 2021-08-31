package com.ss.testing_aws.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.testing_aws.controller.dto.CreateRestaurantDto;
import com.ss.testing_aws.controller.service.RestaurantService;
import com.ss.testing_aws.entity.Restaurant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class RestaurantAdminController {

	private final RestaurantService restaurantService;

	@GetMapping("/restaurants")
	public List<Restaurant> getAllRestaurants(){
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();

		return restaurants;
	}
	
	@PostMapping("/restaurants")
	public ResponseEntity<UUID> createNewRestaurant(@Valid @RequestBody CreateRestaurantDto createRestaurantDto) {
		Restaurant restaurant = restaurantService.createNewRestaurant(createRestaurantDto);
		UUID restaurantId = restaurant.getRestaurantId();
		return ResponseEntity.created(URI.create("/admin/restaurants/" + restaurantId + "/category-collection")).body(restaurantId);
	}


}
