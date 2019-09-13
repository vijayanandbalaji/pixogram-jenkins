package com.pixogram.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.pixogram.model.PostDetails;
import com.pixogram.pixogram.model.UserDetails;
import com.pixogram.pixogram.repository.PostRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	PostRepository postRepository;

	// this is used to upload the image
	@PostMapping(value = "/upload")
	public String uploadMultipartFile(@RequestParam("user") UserDetails user, @RequestParam("file") MultipartFile file,
			@RequestParam("title") String title, @RequestParam("desc") String description) {
		try {

			System.out.println("To Db !!");
			PostDetails postDetails = new PostDetails(user, file.getBytes(), title, description);
			postRepository.save(postDetails);
			System.out.println("Uploaded!!");
			return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}
	}
	
	
	// this is used to fetch all images by UserId
		@GetMapping(value = "/{userId}")
		public List<PostDetails> getAllPostsByUserId(@PathVariable("userId") long userId) {
			System.out.println("fetching all posts by Userid");
			List<PostDetails> postDetails = new ArrayList<PostDetails>();
			postDetails = postRepository.getAllPostsByUserId(userId);//service.getAllPostsByUserId(userId);
			System.out.println("Displaying media");
			return postDetails;
		}
		
		// this is used to fetch all images
		@GetMapping(value = "/all")
		public List<PostDetails> getAllPosts() {
			System.out.println("fetching all posts");
			
			List<PostDetails> postDetails = new ArrayList<PostDetails>();
			postRepository.findAll().forEach(postDetails::add);
			return postDetails;
		}

}
