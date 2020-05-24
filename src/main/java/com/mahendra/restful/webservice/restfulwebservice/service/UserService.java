package com.mahendra.restful.webservice.restfulwebservice.service;


import java.util.List;
import java.util.Optional;

import com.mahendra.restful.webservice.restfulwebservice.entities.User;

public interface UserService {
		public List<User> findAll();
		
		public Optional<User> findById(int id);

		public User save( User user);

		public void deleteById(int id);
	
}
