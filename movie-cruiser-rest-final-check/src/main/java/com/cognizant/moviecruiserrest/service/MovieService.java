package com.cognizant.moviecruiserrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiserrest.exception.ResourceNotFoundException;
import com.cognizant.moviecruiserrest.model.Movie;
import com.cognizant.moviecruiserrest.repository.MovieRepository;

@Service
public class MovieService {
	
	Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public Iterable<Movie> addMovies(List<Movie> movies) {
		return movieRepository.saveAll(movies);
	}

	@Transactional
	public Iterable<Movie> getMoviesAdmin() {
		return movieRepository.findAll();
	}

	@Transactional
	public Iterable<Movie> getMoviesCustomer() {
		return movieRepository.findMoviesCustomer();
	}
	
	@Transactional
	public Movie getMovieById(Long movieId) {
		return movieRepository.findById(movieId).get();
	}

	@Transactional
	public Movie updateMovie(Movie movie) {
		LOGGER.info("Start");
		Movie movieDb= movieRepository.findById(movie.getId()).get();
		if(movieDb.getId() != movie.getId()) {
			throw new ResourceNotFoundException("Movie not found");
		}
		LOGGER.debug("Movie: {}",movie);
		LOGGER.info("End");
		return movieRepository.save(movie);
	}
	
}
