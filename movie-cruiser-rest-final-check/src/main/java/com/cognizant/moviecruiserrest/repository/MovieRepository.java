package com.cognizant.moviecruiserrest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiserrest.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	
	@Query("select m from Movie m where m.active=1 and m.dateOfLaunch<current_date")
	public Iterable<Movie> findMoviesCustomer();
	
}
