package com.example.demo.dao.imp;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

import dao.ControlDB;
import dao.DbClose;

public class UserDaoImp implements UserDao {
	private static String icons="";

	@Override
	public List<User> getUser(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("User.findUserById");
		query.setParameter(1, id);
		return query.getResultList();

	}

	@Override
	public List<User> getAllUser() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("User.findAll");
		return query.getResultList();
	}

	@Override
	public boolean checkLogin(String username, String password) {
		System.out.println("UserDaoImp中的username:" + username);
		//
		// EntityManagerFactory
		// factory=Persistence.createEntityManagerFactory("demo-2");
		// EntityManager em=factory.createEntityManager();
		// String queryString = "SELECT u.password FROM User u where u.username =?1";
		// //Query query = em.createQuery(queryString);
		// //query.setParameter(1, username);
		// List result=em.createQuery(queryString).setParameter(1,
		// username).getResultList();
		// Object[] objects = (Object[]) result.get(0);
		// System.out.println("查询到的密码是:"+objects[0]);
		// return (String) objects[0];

		String sql = "select * from user where username='" + username + "'";// 查询该卡的密码
		ResultSet rs = null;
		String pass = null;
		try {
			rs = ControlDB.executeQuery(sql);
			while (rs.next())// 检查账号是否存在。
			{
				pass = rs.getString("password");
				if (pass.equals(password)) {
					DbClose.close(rs);
					return true;
				}
				DbClose.close(rs);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean register(String username, String password, BigInteger phone, BigInteger card,String regdate) {
		String sql = "INSERT INTO user( username, password, phone, card,regdate) VALUES ('" + username + "','" + password + "',"
				+ phone + "," + card + ",'"+regdate+"')";
		try {
			if (ControlDB.executeUpate(sql)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getIdByusername(String topicusername) {
		String sql = "select * from user where username='" + topicusername + "'";// 通过账号查询用户id
		ResultSet rs = null;
		int id = 0;
		try {
			rs = ControlDB.executeQuery(sql);
			while (rs.next())// 检查账号是否存在。
			{
				id = Integer.parseInt(rs.getString("id"));
				DbClose.close(rs);
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//上传图片
			@Override
			public String uploadIcons(MultipartFile file) {
			   	if(file!=null){  
		            //获取上传文件的原始名称  
		            String originalFilename = file.getOriginalFilename();  
		            String newFileName ="";  
		            String pic_path;  
		            // 上传图片  
		            if ( originalFilename != null && originalFilename.length() > 0) {  
		                //获取Tomcat服务器所在的路径  
		                String tomcat_path = System.getProperty( "user.dir" );  
		                System.out.println(tomcat_path);  
		                //获取Tomcat服务器所在路径的最后一个文件目录  
		                String bin_path = tomcat_path.substring(tomcat_path.lastIndexOf("\\")+1,tomcat_path.length());  
		                System.out.println(bin_path);  
		                //若最后一个文件目录为bin目录，则服务器为手动启动  
		                if(("bin").equals(bin_path)){//手动启动Tomcat时获取路径为：D:\Software\Tomcat-8.5\bin  
		                    //获取保存上传图片的文件路径  
		                    pic_path = tomcat_path.substring(0,System.getProperty( "user.dir" ).lastIndexOf("\\")) +"\\upload"+"\\img\\";  
		                }else{//服务中自启动Tomcat时获取路径为：D:\Software\Tomcat-8.5  
		                    //pic_path = tomcat_path+"\\webapps"+"\\pic_file\\";  
		                	pic_path=tomcat_path+"\\upload"+"\\icon\\"+"\\icons\\";
		                }  
		                // 新的图片名称  
		                newFileName =UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf(".")); 
		                System.out.println("\\upload"+"\\icon\\"+"\\icons\\"+newFileName);
		                System.out.println("上传图片的路径：" + pic_path + newFileName);
		                // 新图片  
		                File newFile = new File(pic_path + newFileName);  
		                // 将内存中的数据写入磁盘  
		                try {
							file.transferTo(newFile);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}  
		            }  
		            
		            icons="https://www.tengfeistudio.cn/showImg?url=upload/icon/icons/"+newFileName;
		            System.out.println(icons);
//		    		String sql = "insert into activity(img) values('"+img+"') ";
//		    		try {
//						ControlDB.executeUpate(sql);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
		    				
		    		
		            
		            
		            return newFileName;  
		        }else{  
		            return null;  
		        }  

			}

	@Override
	public int updateUser(String password, String email, BigInteger phone, BigInteger card, String realname,
			 String username,String icon) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
//		EntityManager em = factory.createEntityManager();
//		Query query = em.createNamedQuery("User.modifyUser");
//		query.setParameter(1, password);
//		query.setParameter(2, email);
//		query.setParameter(3, phone);
//		query.setParameter(4, card);
//		query.setParameter(5, realname);
//		query.setParameter(6, icons);
//		query.setParameter(7, username);
//		return query.executeUpdate();
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
//		EntityManager em = factory.createEntityManager();
//		String queryString = "update User u set u.password= ?1,u.email= ?2,u.phone= ?3,u.card= ?4,u.realname= ?5,u.icon= ?6 WHERE u.username= ?7";
//		Query query = em.createQuery(queryString);
//		query.setParameter(1, password);
//		query.setParameter(2, email);
//		query.setParameter(3, phone);
//		query.setParameter(4, card);
//		query.setParameter(5, realname);
//		query.setParameter(6, icons);
//		query.setParameter(7, username);
//		return query.executeUpdate();
		

		String sql="UPDATE User SET password='"+password+"',email='"+email+"',phone="+phone+",card="+card+",realname='"+realname+"',icon='"+icon+"' where username='"+username+"' ";
		try {
			ControlDB.executeUpate(sql);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
