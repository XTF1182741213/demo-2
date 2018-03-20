 package com.example.demo.dao.imp;

import java.io.File;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.TopicDao;
import com.example.demo.entity.Topic;
import com.example.demo.entity.User;

import dao.ControlDB;
import dao.DbClose;

public class TopicDaoImp implements TopicDao {
	//private static String picture="";
	//上传图片
			@Override
			public String uploadPicture(MultipartFile file) {
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
		                	pic_path=tomcat_path+"\\upload"+"\\img\\";
		                }  
		                // 新的图片名称  
		                newFileName =UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf(".")); 
		                System.out.println("\\upload"+"\\img\\"+newFileName);
		                System.out.println("TopicDaoImp上传图片的路径：" + pic_path + newFileName);
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
		            
		            //picture="https://www.tengfeistudio.cn/showImg?url=upload/img/"+newFileName;
		            //System.out.println(picture);	
		            
		            
		            return newFileName;  
		        }else{  
		            return null;  
		        }  

			}
	@Override
	public List<Topic> getTopic(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Topic.findTopicById");
		query.setParameter(1, id);
		return query.getResultList();

	}

	@Override
	public List<Topic> getAllTopic() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Topic.findAll");
		return query.getResultList();
	}
	
	@Override
	public boolean addTopic(String theme,String detail, int userid,String title,String picture) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String publishtime=df.format(new Date()).toString();
		//System.out.println("topicDaoImp中的图片picture："+picture);
		String sql="insert into topic(theme,title,detail,userid,datetime,picture) values ('"+theme+"','"+title+"','"+detail+"','"+userid+"','"+publishtime+"','"+picture+"') ";
		try {
			if (ControlDB.executeUpate(sql)) {
				picture="";
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int addPraise(int userid, int topicid,int praise) {
	    String sql="UPDATE Topic set praise="+praise+" where id="+topicid+" ";
		try {
			ControlDB.executeUpate(sql);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
