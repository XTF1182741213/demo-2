package com.example.demo.dao;

import java.math.BigInteger;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Topic;
import com.example.demo.entity.User;



public interface TopicDao {
	
	String uploadPicture( MultipartFile file);//上传图片
	List<Topic> getTopic(int id);
	List<Topic> getAllTopic();
	boolean addTopic(String theme,String detail,int userid,String title,String picture);
	int addPraise(int userid,int topicid,int praise);


}
