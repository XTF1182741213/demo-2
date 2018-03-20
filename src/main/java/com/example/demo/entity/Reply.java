package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the reply database table.
 * 
 */
@Entity
@JsonIgnoreProperties(value= {"topic"})
//@JsonIgnoreProperties(value= {"user"})
@Table(name="reply")
@NamedQueries(value= {
		@NamedQuery(name="Reply.findAll", query="SELECT r FROM Reply r order by r.id desc"),//id倒序
		@NamedQuery(name="Reply.findReplyByTopicId",query="SELECT r FROM Reply r where r.replyId=?1")
})
public class Reply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="reply_datetime", nullable=false, length=32)
	private String replyDatetime;

	@Lob
	@Column(name="reply_detail", nullable=false)
	private String replyDetail;

	@Column(name="reply_id", nullable=false)
	private int replyId;

	@Column(name="reply_name", nullable=false, length=32)
	private String replyName;

	@Column(name="reply_picture", nullable=false, length=100)
	private String replyPicture;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="topic_id", nullable=false)
	private Topic topic;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	public Reply() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReplyDatetime() {
		return this.replyDatetime;
	}

	public void setReplyDatetime(String replyDatetime) {
		this.replyDatetime = replyDatetime;
	}

	public String getReplyDetail() {
		return this.replyDetail;
	}

	public void setReplyDetail(String replyDetail) {
		this.replyDetail = replyDetail;
	}

	public int getReplyId() {
		return this.replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyName() {
		return this.replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getReplyPicture() {
		return this.replyPicture;
	}

	public void setReplyPicture(String replyPicture) {
		this.replyPicture = replyPicture;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}