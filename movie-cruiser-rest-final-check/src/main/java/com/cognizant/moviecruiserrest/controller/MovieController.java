package com.cognizant.moviecruiserrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiserrest.model.Movie;
import com.cognizant.moviecruiserrest.service.MovieService;

@RestController
public class MovieController {
	
	Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{movieId}")
	public Movie getMovieById(@PathVariable("movieId")Long movieId) {
		LOGGER.info("Start");
		LOGGER.debug("Movie Id:{}",movieId);
		LOGGER.info("End");
		return movieService.getMovieById(movieId);
	}
	
	@GetMapping("/admin/movies")
	public Iterable<Movie> getMoviesAdmin() {
		LOGGER.info("Start");
		Iterable<Movie> movies=movieService.getMoviesAdmin();
		LOGGER.debug("Movies:{}",movies);
		LOGGER.info("End");
		return movies;
	}
	
	@PutMapping("/admin/update")
	public Movie updateMoviesAdmin(@RequestBody Movie movie) {		
		return movieService.updateMovie(movie);
	}
	
	@GetMapping("/customer/movies")
	public Iterable<Movie> getMoviesCustomer() {
		LOGGER.info("Start");
		Iterable<Movie> movies=movieService.getMoviesCustomer();
		LOGGER.debug("Movies:{}",movies);
		LOGGER.info("End");
		return movies;
	}
	
}
