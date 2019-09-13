package com.pixogram.pixogram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pixogram.pixogram.model.PostDetails;

public interface PostRepository extends JpaRepository<PostDetails, Long> {
	
	@Query("select p from PostDetails p where p.userId.id= :userId")
	List<PostDetails> getAllPostsByUserId(@Param("userId") long userId);
}
