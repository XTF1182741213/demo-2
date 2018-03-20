package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@JsonIgnoreProperties(value= {"topics","replies","activities"})
@Table(name="user")
@NamedQueries(value= {
   @NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
   @NamedQuery(name="User.findUserById",query="SELECT u FROM User u WHERE u.id = ?1")
   //@NamedQuery(name="User.modifyUser",query="update User u set u.password= ?1,u.email= ?2,u.phone= ?3,u.card= ?4,u.realname= ?5,u.icon= ?6 WHERE u.username= ?7")
   
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	private BigInteger card;

	@Column(length=32)
	private String cardpassword;

	@Column(length=32)
	private String email;

	@Column(length=100)
	private String icon;

	@Column(nullable=false)
	private int level;

	@Column(nullable=false, length=32)
	private String password;

	private BigInteger phone;

	@Column(length=50)
	private String realname;

	@Column(nullable=false, length=32)
	private String regdate;

	@Column(nullable=false)
	private int state;

	@Column(nullable=false, length=32)
	private String username;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="user")
	private List<Activity> activities;

	//bi-directional many-to-one association to Reply
	@OneToMany(mappedBy="user")
	private List<Reply> replies;

	//bi-directional many-to-one association to Topic
	@OneToMany(mappedBy="user")
	private List<Topic> topics;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getCard() {
		return this.card;
	}

	public void setCard(BigInteger card) {
		this.card = card;
	}

	public String getCardpassword() {
		return this.cardpassword;
	}

	public void setCardpassword(String cardpassword) {
		this.cardpassword = cardpassword;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getPhone() {
		return this.phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getRegdate() {
		return this.regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setUser(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setUser(null);

		return activity;
	}

	public List<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public Reply addReply(Reply reply) {
		getReplies().add(reply);
		reply.setUser(this);

		return reply;
	}

	public Reply removeReply(Reply reply) {
		getReplies().remove(reply);
		reply.setUser(null);

		return reply;
	}

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic addTopic(Topic topic) {
		getTopics().add(topic);
		topic.setUser(this);

		return topic;
	}

	public Topic removeTopic(Topic topic) {
		getTopics().remove(topic);
		topic.setUser(null);

		return topic;
	}

}