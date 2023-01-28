package com.hostmdy.car.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.car.domain.User;

public interface UserService {
	User saveOrUpdate(User user);
	Optional<User> getUserById(Long id);
	List<User> findAll();
	void deleteById(Long id);
}

