package com.example.demo.dao;

import java.math.BigInteger;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;



public interface UserDao {
	
   //@Query("select * from activity a where a.id = ?1", nativeQuery = true)
    //@Query("selct * from activity ")
	List<User> getUser(int id);
	List<User> getAllUser();
	boolean checkLogin(String username,String password);//检查账号密码是否正确
	boolean register(String username, String password, BigInteger phone, BigInteger card,String regdate);//注册账号
	int getIdByusername(String username);
	int updateUser(String password,String email,BigInteger phone,BigInteger card,String realname,String username,String icon);
	String uploadIcons(MultipartFile file);
}
