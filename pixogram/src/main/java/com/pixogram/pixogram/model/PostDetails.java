package com.pixogram.pixogram.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@SequenceGenerator(name = "seq2", initialValue = 1, allocationSize = 100)
public class PostDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	UserDetails userId;

	@Lob
	@Column(name="images")
	private byte[] image;

	@Column(name="likes")
	private long liked;

	@Column(name="unlike")
	private long unlike;

	@Column(name="comments")
	private String comments;

	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;

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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public long getLiked() {
		return liked;
	}

	public void setLiked(long liked) {
		this.liked = liked;
	}

	public long getUnlike() {
		return unlike;
	}

	public void setUnlike(long unlike) {
		this.unlike = unlike;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PostDetails [id=" + id + ", userId=" + userId + ", image=" + Arrays.toString(image) + ", liked=" + liked
				+ ", unlike=" + unlike + ", comments=" + comments + ", title=" + title + ", description=" + description
				+ "]";
	}

	public PostDetails(UserDetails userId, byte[] image,   String title,
			String description) {
		
		this.userId = userId;
		this.image = image;
		this.liked = 0;
		this.unlike =0;
		this.comments = "Good!!";
		this.title = title;
		this.description = description;
	}

	public PostDetails() {
		
	}

	
	
	
}
