package com.cognizant.moviecruiserrest.model;

import java.util.HashSet;
import java.util.Set;

public class Favorites {
	private int count;
	private Set<Movie> movies;
	
	public Favorites() {
		super();
		movies=new HashSet<Movie>();
	}

	public Favorites(int count, Set<Movie> movies) {
		super();
		this.count = count;
		this.movies = movies;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Favorites [count=" + count + ", movies=" + movies + "]";
	}
	
}
