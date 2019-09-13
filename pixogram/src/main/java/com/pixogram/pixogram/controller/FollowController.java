package com.pixogram.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixogram.pixogram.model.FollowDetails;
import com.pixogram.pixogram.repository.FollowRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/follow")
public class FollowController {

	@Autowired
	FollowRepository followRepository;

	@PostMapping(value = "/following/user")
	public FollowDetails followuser(@RequestBody FollowDetails followDetails) {
		FollowDetails followDetails2 = followRepository.save(followDetails);
		System.out.println("User Followed");
		return followDetails2;
	}

	
	@GetMapping(path = "/display/followers/{followId}")
	public List<FollowDetails> followers(@PathVariable("followId") Long id) {
		List<FollowDetails> followers=new ArrayList<>();
		followRepository.followers(id).forEach(followers::add);
		System.out.println(followers);
		return followers;
	}
	
	

	@GetMapping(path = "/display/following/{userId}")
	public List<FollowDetails> following(@PathVariable("userId") Long id) {
		List<FollowDetails> following=new ArrayList<>();
		followRepository.following(id).forEach(following::add);
		System.out.println(following);
		return following;
	}
	
	@DeleteMapping(value="/delete/{Id}")
	public String unFollowUser(@PathVariable("Id") long id) {
		System.out.println("unfollowing the user");
		followRepository.deleteById(id);
		System.out.println("user unfollowed");
		return "User has unfollowed";
	}

}
