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
@Table(name = "block")
@SequenceGenerator(name = "seq4", initialValue = 1, allocationSize = 100)
public class BlockDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq4")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	UserDetails userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "block_id")
	UserDetails blockId;

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

	public UserDetails getBlockId() {
		return blockId;
	}

	public void setBlockId(UserDetails blockId) {
		this.blockId = blockId;
	}

	@Override
	public String toString() {
		return "BlockDetails [id=" + id + ", userId=" + userId + ", blockId=" + blockId + "]";
	}

	public BlockDetails(UserDetails userId, UserDetails blockId) {
		
		this.userId = userId;
		this.blockId = blockId;
	}

	public BlockDetails() {
		
	}
	
	

}
