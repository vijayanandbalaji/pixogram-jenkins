package com.pixogram.pixogram.controller;

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

import com.pixogram.pixogram.model.BlockDetails;
import com.pixogram.pixogram.repository.BlockRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/block")
public class BlockController {
	@Autowired
	BlockRepository blockRepository;
	
	//blocking user
		@PostMapping(value="/block")
		public long blockUser(@RequestBody BlockDetails blockDetails) {
			return 1;
		}
		
		//getAllBlockedByuserID
		@GetMapping(value="/{userId}")
		public List<BlockDetails> getAllBlockedByUserId(@PathVariable("userId") long id){
			return null;
		}
		
		//unblock user
		@DeleteMapping(value="/{id}")
		public String unBlock(@PathVariable("id") long id) {
			return "hi";
		}

}
