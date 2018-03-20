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
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;
import com.example.demo.repository.TopicRepository;

@RestController
public class TopicController {

	@Autowired
	private TopicRepository topicRepository;

	// 分页查询
	@RequestMapping(value = "/topicparams", method = RequestMethod.GET)
	public Page<Topic> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		return topicRepository.findAll(pageable);
	}

	// 根据username查询topic
	@RequestMapping(value = "/findtopicbyuserid", method = RequestMethod.GET)
	public List<Topic> getTopics(@RequestParam(value = "usernames") String usernames) {
		int userid = DaoFactory.getUserDao().getIdByusername(usernames);
		System.out.println("userid是" + userid);
		return topicRepository.findByUser_Id(userid);
		// return topicRepository.findByUser_IdByOrderByIdDesc(userid);

	}

	// 通过id对topic进行删除
	@RequestMapping(value = "/deletetopicbyid", method = RequestMethod.GET)
	public boolean deleteTopic(@RequestParam(value = "id") int id) {
		try {
			topicRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 查询数量
	@RequestMapping(value = "/counttopicbyuserid", method = RequestMethod.GET)
	public int countActivity(@RequestParam(value = "usernames") String usernames) {
		int userid = DaoFactory.getUserDao().getIdByusername(usernames);
		return topicRepository.countByUser_Id(userid);

	}

	@RequestMapping(value = "/gettopicbyid", method = RequestMethod.GET)
	public Topic findTopicById(@RequestParam(value = "topicid") int topicid) {
		return topicRepository.findOne(topicid);
	}

	// 查询赞的数量
	@RequestMapping(value = "/countpraisebytopicid", method = RequestMethod.GET)
	public int countPraise(@RequestParam(value = "topicid") int topicid) {
		return topicRepository.countPraiseById(topicid);
	}

	// 下面是自己写的方法
	@RequestMapping("/getalltopic")
	List<Topic> getAllTopic(HttpServletRequest request, HttpServletResponse response) {
		return DaoFactory.getTopicDao().getAllTopic();
	}

	@RequestMapping("/gettopic")
	public List<Topic> getTopic(@RequestParam("id") int id) {
		return DaoFactory.getTopicDao().getTopic(id);
	}

	@RequestMapping("/addtopic")
	public boolean addTopic(@RequestParam("theme") String theme, @RequestParam("title") String title,
			@RequestParam("detail") String detail, @RequestParam("topicusername") String topicusername,
			@RequestParam("picture") String picture) {
		int userid = DaoFactory.getUserDao().getIdByusername(topicusername);
		System.out.println("title=" + title);
		System.out.println("detail=" + detail);
		System.out.println("userid=" + userid);
		return DaoFactory.getTopicDao().addTopic(theme, detail, userid, title, picture);
	}

	// 处理文件上传
	@RequestMapping(value = "/uploadpicture")
	public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		return DaoFactory.getTopicDao().uploadPicture(file);
	}

	// 点赞数保存
	@RequestMapping(value = "/addpraise")
	public int addPraise(@RequestParam("username") String username, @RequestParam("praise") int praise,
			@RequestParam("topicid") int topicid) {
		int userid = DaoFactory.getUserDao().getIdByusername(username);
		System.out.println("点赞中的:" + username);
		System.out.println("点赞中的:" + praise);
		System.out.println("点赞中的:" + topicid);
		return DaoFactory.getTopicDao().addPraise(userid, topicid, praise);
	}
}
