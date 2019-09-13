package com.pixogram.pixogram.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "follow")
@SequenceGenerator(name = "seq3", initialValue = 1, allocationSize = 100)
public class FollowDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq3")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	UserDetails userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "follow_id")
	UserDetails followId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

	public UserDetails getFollowId() {
		return followId;
	}

	public void setFollowId(UserDetails followId) {
		this.followId = followId;
	}

	@Override
	public String toString() {
		return "FollowDetails [id=" + id + ", userId=" + userId + ", followId=" + followId + "]";
	}

	public FollowDetails(UserDetails userId, UserDetails followId) {
		
		this.userId = userId;
		this.followId = followId;
	}

	public FollowDetails() {
		
	}
	
	
}
