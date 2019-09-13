package com.pixogram.pixogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pixogram.pixogram.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
	@Query("Select u From UserDetails u where u.name = :name and u.password = :password")
	UserDetails checkNameAndPassword(@Param("name") String name, @Param("password") String password);

}
