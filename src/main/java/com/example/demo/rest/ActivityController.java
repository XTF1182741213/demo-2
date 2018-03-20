package com.example.demo.rest;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.imp.DaoFactory;
import com.example.demo.entity.Activity;
import com.example.demo.repository.ActivityRepository;

@RestController
public class ActivityController {
	@Autowired
	ActivityRepository activityRepository;
	private static int nameid = 1;
	private static String username = " ";
	private static int activityid = 0;

	// 分页查询activity
	@RequestMapping(value = "/activityparams", method = RequestMethod.GET)
	public Page<Activity> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		return activityRepository.findAll(pageable);
	}

	// 根据username查询activity
	@RequestMapping(value = "/findactivitybyuserid", method = RequestMethod.GET)
	public List<Activity> getActivityss(@RequestParam(value = "usernames") String usernames) {
		int userid = DaoFactory.getUserDao().getIdByusername(usernames);
		username = usernames;
		return activityRepository.findByUser_Id(userid);

	}

	// 根据id查找activity
	@RequestMapping(value = "/findbyactivityid", method = RequestMethod.GET)
	public Activity findActivity(@RequestParam(value = "id") int id) {
		return activityRepository.findOne(id);
	}

	// 根据id删除activity
	@RequestMapping(value = "/deleteactivitybyid", method = RequestMethod.GET)
	public boolean deleteActivity(@RequestParam(value = "id") int id) {
		try {
			activityRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// //根据id修改activity
	// @RequestMapping(value="/modifyactivitybyid",method=RequestMethod.GET)
	// public boolean modifyActivity(@RequestParam(value="id") int id) {
	// Activity activity=new Activity();
	// try {
	// activityRepository.save(activity);
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// }
	// }
	// 查询数量
	@RequestMapping(value = "/countactivitybyuserid", method = RequestMethod.GET)
	public int countActivity(@RequestParam(value = "usernames") String usernames) {
		int userid = DaoFactory.getUserDao().getIdByusername(usernames);
		return activityRepository.countByUser_Id(userid);

	}


	//
	// @RequestMapping(value = "", method=RequestMethod.GET)
	// public Page<Activity> getEntryByPageable(@PageableDefault(value = 15, sort =
	// { "id" }, direction = Sort.Direction.DESC)
	// Pageable pageable) {
	// return activityRepository.findAll(pageable);
	// }

	@RequestMapping("/getallactivity")
	List<Activity> getAllActivity(HttpServletRequest request, HttpServletResponse response) {
		return DaoFactory.getActivityDao().getAllActivity();
	}

	@RequestMapping("/getactivity")
	public List<Activity> getActivity(@RequestParam("id") int id) {
		System.out.println("传过来的id:" + id);
		return DaoFactory.getActivityDao().getActivity(id);
	}

	// 通过用户名得到id
	@RequestMapping("/agetuserid")
	public int getIdByusername(@RequestParam("username") String username) {
		nameid = DaoFactory.getUserDao().getIdByusername(username);
		return DaoFactory.getUserDao().getIdByusername(username);
	}

	@RequestMapping("/addactivity")
	public boolean addActivity(@RequestParam("title") String title, @RequestParam("time") String time,
			@RequestParam("content") String content, @RequestParam("place") String place,
			@RequestParam("type") int type, @RequestParam("rank") boolean rank, @RequestParam("sponsor") String sponsor,
			@RequestParam("target") String target, @RequestParam("aname") String aname, @RequestParam("img") String img,
			@RequestParam("picture") String picture, @RequestParam("username") String username) {
		System.out.println("title:" + title + " time:" + time + " content:" + content + " place:" + place);
		System.out.println(
				"type:" + type + " rank:" + rank + " sponsor:" + sponsor + " target:" + target + " aname:" + aname);
		// System.out.println("nameid:"+nameid);
		int usernameid=DaoFactory.getUserDao().getIdByusername(username);
		System.out.println("发布人的id是："+usernameid);
		return DaoFactory.getActivityDao().addActivity(title, time, content, place, type, rank, sponsor, target, aname,
				usernameid, img, picture);
	}

	// 处理文件上传
	@RequestMapping(value = "/uploadimg")
	public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		return DaoFactory.getActivityDao().uploadImg(file);
	}

	@RequestMapping(value = "/showImg")
	public void imageShow(HttpServletResponse response, @ModelAttribute("url") String url) {
		DaoFactory.getActivityDao().imageShow(response, url);
	}

	@RequestMapping(value = "/findImgById")
	public String fingImg(@RequestParam("id") int id) {
		System.out.println("findImgById:" + id);
		System.out.println(DaoFactory.getActivityDao().findImg(id));
		return DaoFactory.getActivityDao().findImg(id);
	}

	@RequestMapping("/getactivitys")
	public List<Activity> getActivitys(@RequestParam("username") String username) {
		int userid = DaoFactory.getUserDao().getIdByusername(username);
		System.out.println("得到的:" + userid);
		return DaoFactory.getActivityDao().getActivitys(userid);
	}

	@RequestMapping("/getactivityid")
	public int getActivityId(@RequestParam("id") int id) {
		activityid = id;
		return id;
	}

	// 更新活动信息
	@RequestMapping("/modifyactivity")
	public boolean updateActivity(String title, String time, String content, String place, String types, String rank,
			String sponsor, String target, String aname,String img,String picture,int actid) {

		return DaoFactory.getActivityDao().updateActivity(title, time, content, place, types, rank, sponsor, target,
				aname, actid,img,picture);
	}

}
