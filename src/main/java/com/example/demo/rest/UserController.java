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
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("/findAllUser")
    public List<User> findAll(){
    	return userRepository.findAll();
    }
    @RequestMapping("/findUserById")
    public User findById(int id) {
    	System.out.println("Repository的id是:"+id);
    	return userRepository.findOne(id);
    }
    @RequestMapping("/findUserByUsername")
    public User findByUsername(String username) {
    	System.out.println("Repository的username是"+username);
    	return userRepository.findByUsername(username);
    }
    
    
    
    @RequestMapping("/exitUser")
    public boolean exitUser(@RequestParam(value="username") String username) {
    	int userid=DaoFactory.getUserDao().getIdByusername(username);
    	try {
			userRepository.exists(userid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    
    //分页查询
//	 @RequestMapping(value = "/userparams", method=RequestMethod.GET)
//	 public Page<User> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,@RequestParam(value = "size", defaultValue = "10") Integer size) {
//	     Sort sort = new Sort(Direction.DESC, "id");
//	     Pageable pageable = new PageRequest(page, size, sort);
//	     return userRepository.findAll(pageable);
//	 }

	@RequestMapping("/getalluser")
	List<User> getAllUser(HttpServletRequest request,HttpServletResponse response){
		return DaoFactory.getUserDao().getAllUser();
	}
	@RequestMapping("/getuser")
	public List<User> getUser(@RequestParam("id") int id){
		return DaoFactory.getUserDao().getUser(id);
	}
	@RequestMapping("/login")
	public boolean login(@RequestParam("username") String username,@RequestParam("password") String password) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(DaoFactory.getUserDao().checkLogin(username, password));
	    return DaoFactory.getUserDao().checkLogin(username, password);
		
	}
	@RequestMapping("/register")
	public boolean register(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("phone") BigInteger phone, @RequestParam("card") BigInteger card) {
		System.out.println(username);
		System.out.println(password);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String regdate=df.format(new Date()).toString();
		System.out.println(regdate);
		return DaoFactory.getUserDao().register(username, password, phone, card,regdate);
	}
	@RequestMapping("/getuserid")
	public int getIdByusername(@RequestParam("username") String username) {
		return DaoFactory.getUserDao().getIdByusername(username);
	}
	
	//处理文件上传
    @RequestMapping(value="/uploadicons")
    public String uploadIcons(@RequestParam("file") MultipartFile file,HttpServletRequest request) {

        return DaoFactory.getUserDao().uploadIcons(file);
    }
	@RequestMapping("/modifyuserbyusername")
	public int updateUsername(@RequestParam("password")String password,@RequestParam("email") String email,@RequestParam("phone") BigInteger phone,@RequestParam("card") BigInteger card,@RequestParam("realname") String realname,
			@RequestParam("username") String username,@RequestParam("icon") String icon) {
		return DaoFactory.getUserDao().updateUser(password, email, phone, card, realname, username,icon);
	}
	
	
	
	
	
}
