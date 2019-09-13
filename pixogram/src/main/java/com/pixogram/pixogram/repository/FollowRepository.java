package com.pixogram.pixogram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pixogram.pixogram.model.FollowDetails;

public interface FollowRepository extends JpaRepository<FollowDetails, Long> {
	@Query("select f from FollowDetails f where f.followId.id = :followId")
	List<FollowDetails> followers(@Param("followId") long id);

	@Query("select f from FollowDetails f where f.userId.id = :userId")
	List<FollowDetails> following(@Param("userId") long id);

}
