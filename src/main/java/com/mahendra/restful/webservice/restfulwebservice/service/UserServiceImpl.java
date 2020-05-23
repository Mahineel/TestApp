package com.mahendra.restful.webservice.restfulwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahendra.restful.webservice.restfulwebservice.entities.User;
import com.mahendra.restful.webservice.restfulwebservice.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
