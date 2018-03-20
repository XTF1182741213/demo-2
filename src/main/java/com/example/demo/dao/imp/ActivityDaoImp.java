package com.example.demo.dao.imp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.ActivityDao;
import com.example.demo.entity.Activity;

import dao.ControlDB;
import dao.DbClose;

public class ActivityDaoImp implements ActivityDao {
	private static String imgs = "";

	@Override
	public List<Activity> getActivity(int id) {
		// EntityManagerFactory
		// factory=Persistence.createEntityManagerFactory("demo-2");
		// EntityManager em=factory.createEntityManager();
		// Query query=em.createNamedQuery("Activity.findActivtyById");
		// query.setParameter(1, id);
		// return query.getResultList();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
		EntityManager em = factory.createEntityManager();
		String queryString = "SELECT a FROM Activity a where a.id =?1";
		Query query = em.createQuery(queryString);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@Override
	public List<Activity> getAllActivity() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Activity.findAll");
		return query.getResultList();

	}

	// 上传图片
	@Override
	public String uploadImg(MultipartFile file) {
		if (file != null) {
			// 获取上传文件的原始名称
			String originalFilename = file.getOriginalFilename();
			String newFileName = "";
			String pic_path;
			// 上传图片
			if (originalFilename != null && originalFilename.length() > 0) {
				// 获取Tomcat服务器所在的路径
				String tomcat_path = System.getProperty("user.dir");
				System.out.println(tomcat_path);
				// 获取Tomcat服务器所在路径的最后一个文件目录
				String bin_path = tomcat_path.substring(tomcat_path.lastIndexOf("\\") + 1, tomcat_path.length());
				System.out.println(bin_path);
				// 若最后一个文件目录为bin目录，则服务器为手动启动
				if (("bin").equals(bin_path)) {// 手动启动Tomcat时获取路径为：D:\Software\Tomcat-8.5\bin
					// 获取保存上传图片的文件路径
					pic_path = tomcat_path.substring(0, System.getProperty("user.dir").lastIndexOf("\\")) + "\\upload"
							+ "\\img\\";
				} else {// 服务中自启动Tomcat时获取路径为：D:\Software\Tomcat-8.5
						// pic_path = tomcat_path+"\\webapps"+"\\pic_file\\";
					pic_path = tomcat_path + "\\upload" + "\\img\\";
				}
				// 新的图片名称
				newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
				System.out.println("\\upload" + "\\img\\" + newFileName);
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

			imgs = "https://www.tengfeistudio.cn/showImg?url=upload/img/" + newFileName;
			System.out.println(imgs);
			// String sql = "insert into activity(img) values('"+img+"') ";
			// try {
			// ControlDB.executeUpate(sql);
			// } catch (Exception e) {
			// e.printStackTrace();
			// }

			return "https://www.tengfeistudio.cn/showImg?url=upload/img/"+newFileName;
		} else {
			return null;
		}

	}

	@Override
	public boolean addActivity(String title, String time, String content, String place, int type, boolean rank,
			String sponsor, String target, String aname, int userid, String img, String picture) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String ctime = df.format(new Date()).toString();
		// '无', '思德素拓', '文化素拓', '身心素拓', '双创素拓', '技能素拓
		String types = "无";
		if (type == 0)
			types = "无";
		else if (type == 1)
			types = "思德素拓";
		else if (type == 2)
			types = "文化素拓";
		else if (type == 3)
			types = "身心素拓";
		else if (type == 4)
			types = "双创素拓";
		else if (type == 5)
			types = "技能素拓";
		String ranks = "院级";
		if (rank)
			ranks = "院级";
		else
			ranks = "校级";

		// System.err.println("插入数据库中的imgs:" + imgs);
		String sql = "insert into activity(title,img,time,ctime,content,place,type, rank,sponsor,target,aname,userid,picture) values('"
				+ title + "','" + img + "','" + time + "','" + ctime + "','" + content + "','" + place + "','" + types
				+ "','" + ranks + "','" + sponsor + "','" + target + "','" + aname + "'," + userid + ",'" + picture
				+ "')";
		try {
			if (ControlDB.executeUpate(sql)) {
				//imgs = "";
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	// 修改活动信息
	@Override
	public boolean updateActivity(String title, String time, String content, String place, String types, String rank,
			String sponsor, String target, String aname, int id, String img, String picture) {
		// System.err.println("插入数据库中的imgs:" + imgs);
		/*
		 * String sql =
		 * "insert into activity(title,img,time,ctime,content,place,type, rank,sponsor,target,aname,userid) values('"
		 * + title + "','"+imgs+"','" + time + "','" + ctime + "','" + content + "','" +
		 * place + "','" + types + "','" + ranks + "','" + sponsor +
		 * "','"+target+"','"+aname+"',"+userid+")";
		 */
		String sql = "update activity set title='" + title + "',time='" + time + "',content='" + content + "',place='"
				+ place + "',type='" + types + "',rank='" + rank + "',sponsor='" + sponsor + "',target='" + target
				+ "',aname='" + aname + "',img='" + img + "',picture='"+picture+"' where id=" + id + " ";
		try {
			if (ControlDB.executeUpate(sql)) {
				//imgs = "";
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public void imageShow(HttpServletResponse response, String url) {
		try {
			String s2 = new String(url.getBytes("ISO-8859-1"), "utf-8");
			OutputStream os = response.getOutputStream();
			// File file = new File("d:\\img\\"+s2);
			System.out.println("s2是:" + s2);
			// File file=new File("\\eclipse-workspace\\demo-2\\"+s2);
			File file = new File("C:\\Users\\Administrator\\eclipse-workspace\\demo-2\\" + s2);
			FileInputStream fips = new FileInputStream(file);
			ByteArrayOutputStream bops = new ByteArrayOutputStream();
			int data = -1;
			while ((data = fips.read()) != -1) {
				bops.write(data);
			}
			byte[] btImg = bops.toByteArray();
			os.write(btImg);
			os.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String findImg(int id) {
		String sql = "select img from activity where id=" + id + " ";
		ResultSet rs = null;
		String img = null;
		try {
			rs = ControlDB.executeQuery(sql);
			while (rs.next())//
			{
				img = rs.getString("img");
				DbClose.close(rs);
				return img;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Activity> getActivitys(int userid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-2");
		EntityManager em = factory.createEntityManager();
		Query query = em.createNamedQuery("Activity.findActivityByUserid");
		query.setParameter(1, userid);
		return query.getResultList();
	}

}
