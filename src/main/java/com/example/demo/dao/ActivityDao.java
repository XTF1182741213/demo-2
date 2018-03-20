package com.example.demo.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Activity;



public interface ActivityDao {
	
   
	List<Activity> getActivity(int id); //通过id查询活动
	List<Activity> getAllActivity();  //查询活动列表
	List<Activity> getActivitys(int userid);
	boolean addActivity(String title,String time,String content,String place,int type,boolean rank,String sponsor,String target,String aname,int userid,String img,String picture);
	String uploadImg( MultipartFile file);//上传图片
	void imageShow( HttpServletResponse response,String url);
	String findImg(int id);//通过活动id查找img
	boolean updateActivity(String title, String time, String content, String place, String types, String rank,
			String sponsor, String target, String aname, int id,String img,String picture);
	

}

