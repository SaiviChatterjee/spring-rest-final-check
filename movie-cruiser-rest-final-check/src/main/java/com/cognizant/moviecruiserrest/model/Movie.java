package com.cognizant.moviecruiserrest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mv_id")
	private Long id;

	@Column(name = "mv_title")
	private String title;

	@Column(name = "mv_box_office")
	private String boxOffice;

	@Column(name = "mv_active")
	private boolean active;

	@Temporal(TemporalType.DATE)
	@Column(name = "mv_date_of_launch")
	private Date dateOfLaunch;

	@Column(name = "mv_genre")
	private String genre;

	@Column(name = "mv_has_teaser")
	private boolean hasTeaser;

	@Column(name = "poster")
	private String poster;
	
	public Movie() {
		super();
	}

	public Movie(String title, String boxOffice, boolean active, Date dateOfLaunch, String genre, boolean hasTeaser,
			String poster) {
		super();
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
		this.poster = poster;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", boxOffice=" + boxOffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", hasTeaser=" + hasTeaser + ", poster="
				+ poster + "]";
	}

}
