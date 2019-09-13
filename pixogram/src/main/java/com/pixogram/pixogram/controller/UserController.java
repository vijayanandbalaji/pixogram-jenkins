package com.pixogram.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixogram.pixogram.model.UserDetails;
import com.pixogram.pixogram.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping(value = "/user/create")
	public UserDetails postUser(@RequestBody UserDetails userDetails) {
		UserDetails userDetails2 = userRepository.save(userDetails);
		return userDetails2;
	}
	
	@GetMapping("/user/login/{name}/{password}")
	public UserDetails checkUserLogin(@PathVariable("name") String name,@PathVariable("password") String password) {
		
		UserDetails userDetails=userRepository.checkNameAndPassword(name, password);
		
		System.out.println(userDetails);
			
		return userDetails;
	}
	
	
	@GetMapping("/display/friends")
	public List<UserDetails> displayuser() {
			
		  List<UserDetails> userDetails=new ArrayList<UserDetails>();
		  
		  userRepository. findAll().forEach(userDetails::add);
		  
		  System.out.println(userDetails);
		  return  userDetails;
	}

}
