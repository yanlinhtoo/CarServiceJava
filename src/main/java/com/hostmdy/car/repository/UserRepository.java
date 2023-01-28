package com.hostmdy.car.repository;


import org.springframework.data.repository.CrudRepository;

import com.hostmdy.car.domain.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
}
