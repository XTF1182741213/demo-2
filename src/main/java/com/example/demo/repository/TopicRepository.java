package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Topic;
import com.example.demo.entity.User;

public interface TopicRepository extends JpaRepository<Topic, Integer>{

	List<Topic> findByUser_Id(int userid);
	//User findById(int id);
	//List<User> findAll();

	int countByUser_Id(int userid);

	int countPraiseById(int topicid);

	//List<Topic> findByUser_IdByOrderByIdAtDesc(int userid);
	//List<Topic> findAllByOrderByIdAtDesc();

}
