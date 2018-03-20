package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Activity;
import com.example.demo.entity.User;

@Repository("ActivityRepository")
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Integer>{

	List<Activity> findByUser_Id(int userid);

	int countByUser_Id(int userid);



	//根据id删除Activity
//	@Modifying
//	@Query(value = "delete from activity where id=?1 ", nativeQuery = true)
//	@Modifying
//	@Query("update Activity a set a.userName = ?1 where a.id = ?2")
//	int modifyByIdAndUserId(String  userName, Long id);
//	public void deleteActivityById(int id);
	//Page<Activity> findByDeletedFalse(Pageable pageable);


   
}
