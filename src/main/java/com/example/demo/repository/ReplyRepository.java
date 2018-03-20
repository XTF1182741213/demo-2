package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reply;
import com.example.demo.entity.User;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

	List<Reply> findByUser_Id(int userid);
	//User findById(int id);
	//List<User> findAll();

	int countByUser_Id(int userid);

	List<Reply> findByTopic_Id(int topicid);

}
