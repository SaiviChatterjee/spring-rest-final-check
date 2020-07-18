package com.cognizant.moviecruiserrest.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiserrest.model.Favorites;
import com.cognizant.moviecruiserrest.model.Movie;
import com.cognizant.moviecruiserrest.service.UserService;

@RestController
public class UserController {
	
	Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/customer/add-favorites/{userId}/{movieId}")
	public Iterable<Movie> addFavorites(@PathVariable("userId") Long userId,@PathVariable("movieId") Long movieId){
		LOGGER.info("Start");
		LOGGER.debug("userId: {}, movieId: {}",userId,movieId);
		LOGGER.info("End");
		return userService.addFavorites(userId,movieId);
	}
	
	@GetMapping("/customer/get-favorites/{userId}")
	public Favorites getFavorites(@PathVariable("userId") Long userId){
		LOGGER.info("Start");
		Set<Movie> favorites=(Set<Movie>) userService.getFavorites(userId);
		LOGGER.debug("favorites :{} for user:{}",favorites, userId);
		LOGGER.info("End");
		return new Favorites(favorites.size(),favorites);
	}
	
	@GetMapping("/customer/remove-favorites/{userId}/{movieId}")
	public Iterable<Movie> removeFavorites(@PathVariable("userId") Long userId,@PathVariable("movieId") Long movieId){
		LOGGER.info("Start");
		LOGGER.debug("userId: {}, movieId: {}",userId,movieId);
		LOGGER.info("End");
		return userService.removeFavorites(userId,movieId);
	}
}
