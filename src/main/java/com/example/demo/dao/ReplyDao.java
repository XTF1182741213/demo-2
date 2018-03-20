package com.example.demo.dao;

import java.math.BigInteger;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Reply;
import com.example.demo.entity.User;



public interface ReplyDao {
	
	String uploadCommentPicture( MultipartFile file);//上传图片
	List<Reply> geReply(int replyId);//通过主题Id查询
	List<Reply> getAllReply();
	boolean addReply(int topicid,String replyname,String replydetail,int userid,String replypicture);
}
