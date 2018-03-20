package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topic database table.
 * 
 */
@Entity
//@JsonIgnoreProperties(value= {"replies"})
@Table(name="topic")
@NamedQueries(value= {
		@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t order by t.id desc"),//id倒序
		@NamedQuery(name="Topic.findTopicById",query="SELECT t FROM Topic t where t.id =?1")
})
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=32)
	private String datetime;

	@Lob
	@Column(nullable=false)
	private String detail;

	private byte locked;

	@Column(length=100)
	private String picture;

	private int reply;

	private byte sticky;

	@Column(length=255)
	private String theme;

	@Column(length=50)
	private String title;

	private int view;
	
	private int praise;

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	//bi-directional many-to-one association to Reply
	@OneToMany(mappedBy="topic")
	private List<Reply> replies;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	public Topic() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public byte getLocked() {
		return this.locked;
	}

	public void setLocked(byte locked) {
		this.locked = locked;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getReply() {
		return this.reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public byte getSticky() {
		return this.sticky;
	}

	public void setSticky(byte sticky) {
		this.sticky = sticky;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getView() {
		return this.view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public List<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public Reply addReply(Reply reply) {
		getReplies().add(reply);
		reply.setTopic(this);

		return reply;
	}

	public Reply removeReply(Reply reply) {
		getReplies().remove(reply);
		reply.setTopic(null);

		return reply;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}