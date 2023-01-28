package com.hostmdy.car.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.car.domain.User;
import com.hostmdy.car.repository.UserRepository;
import com.hostmdy.car.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveOrUpdate(User user) {
		return userRepository.save(user);
	}

	@Override	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		Optional<User> UserOpt = userRepository.findById(id);
		userRepository.deleteById(UserOpt.get().getId());
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	
	
}
