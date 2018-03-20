package com.example.demo.rest;

import java.math.BigInteger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.imp.DaoFactory;
import com.example.demo.entity.Activity;
import com.example.demo.entity.Reply;
import com.example.demo.entity.User;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.ReplyRepository;

@RestController
public class ReplyController {
	
	 @Autowired
	 ReplyRepository replyRepository;  
	  
	 //分页查询reply
	 @RequestMapping(value = "/replyparams", method=RequestMethod.GET)
	 public Page<Reply> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,@RequestParam(value = "size", defaultValue = "10") Integer size) {
	     Sort sort = new Sort(Direction.DESC, "id");
	     Pageable pageable = new PageRequest(page, size, sort);
	     return replyRepository.findAll(pageable);
	 }
	 //根据username查询reply
	 @RequestMapping(value="/findreplybyuserid",method=RequestMethod.GET)
	 public List<Reply> getReply(@RequestParam(value="usernames") String usernames){
		 int userid=DaoFactory.getUserDao().getIdByusername(usernames);
		 return replyRepository.findByUser_Id(userid);
		 
	 }
	 //根据id删除reply
	 @RequestMapping(value="/deletereplybyid",method=RequestMethod.GET)
	 public boolean deleteReply(@RequestParam(value="id") int id) {
		 try {
			replyRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	 }
	 //查询数量
	 @RequestMapping(value="/countreplybyuserid",method=RequestMethod.GET)
	 public int countReply(@RequestParam(value="usernames") String usernames){
		 int userid=DaoFactory.getUserDao().getIdByusername(usernames);
		 return replyRepository.countByUser_Id(userid);
		
	 }
	
	//通过topic查询评论
	 @RequestMapping(value="/findreplybytopicid",method=RequestMethod.GET)
	 public List<Reply> getReplyByTopicId(@RequestParam(value="topicid") int topicid){
		 return replyRepository.findByTopic_Id(topicid);
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	//查找所有的评论
	@RequestMapping("/getallreply")
	List<Reply> getAllUser(HttpServletRequest request,HttpServletResponse response){
		return DaoFactory.getReplyDao().getAllReply();
	}

	//通过主题id查找所有的评论  replyid==topicid
	@RequestMapping("/getreplybyreplyid")
	List<Reply> getReplyByReplyId(@RequestParam("replyId") int replyId){
		System.out.println("replyId是"+replyId);
		return DaoFactory.getReplyDao().geReply(replyId);
	}
	//
	@RequestMapping("/addreply")
	public boolean addReply(@RequestParam("topicid") int topicid,@RequestParam("replyname") String replyname, @RequestParam("replydetail") String replydetail,@RequestParam("replypicture") String replypicture) {
		int userid=DaoFactory.getUserDao().getIdByusername(replyname);//通过用户名寻找该用户的id
		return DaoFactory.getReplyDao().addReply(topicid, replyname, replydetail,  userid,replypicture);
	}
	
	//处理文件上传
    @RequestMapping(value="/uploadcommentpicture")
    public String uploadImg(@RequestParam("file") MultipartFile file,HttpServletRequest request) {

        //return DaoFactory.getTopicDao().uploadPicture(file);
    	return DaoFactory.getReplyDao().uploadCommentPicture(file);
    }
	
}
