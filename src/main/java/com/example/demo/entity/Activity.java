package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@JsonIgnoreProperties(value= {"user"})
@NamedQueries(value= {
		@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a order by a.id desc"),//id从大到小排序
		@NamedQuery(name="Activity.findActivtyById",query="SELECT a FROM Activity a where a.id =?1")//通过查询id查询某个方法		
})
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String aname;

	@Lob
	@Column(nullable=false)
	private String content;

	@Column(nullable=false, length=32)
	private String ctime;

	@Column(length=200)
	private String img;

	@Column(length=100)
	private String picture;

	@Column(nullable=false, length=100)
	private String place;

	@Column(nullable=false, length=100)
	private String rank;

	@Column(nullable=false, length=100)
	private String sponsor;

	@Column(length=32)
	private String target;

	@Column(nullable=false, length=32)
	private String time;

	@Column(length=200)
	private String title;

	@Column(nullable=false, length=100)
	private String type;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid", nullable=false)
	private User user;

	public Activity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}