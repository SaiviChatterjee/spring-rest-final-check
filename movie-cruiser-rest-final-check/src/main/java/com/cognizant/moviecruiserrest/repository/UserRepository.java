package com.cognizant.moviecruiserrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiserrest.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
