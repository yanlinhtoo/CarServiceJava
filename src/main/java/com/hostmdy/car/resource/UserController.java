package com.hostmdy.car.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.car.domain.User;
import com.hostmdy.car.service.UserService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user,BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Invalid Validation Error",HttpStatus.BAD_REQUEST);
		}
			User createdUser = userService.saveOrUpdate(user);
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		List<User> userList = userService.findAll();
		if(userList.isEmpty())
			return new ResponseEntity<String>("No User Found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<User> userOpt = userService.getUserById(id);
		if(userOpt.isEmpty())
			return new ResponseEntity<String>("User with id="+id+"is not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(userOpt.get(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Long> deleteById(@PathVariable Long id){
		userService.deleteById(id);
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}
	
}

	