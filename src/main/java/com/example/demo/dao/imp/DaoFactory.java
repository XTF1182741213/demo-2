package com.example.demo.dao.imp;

public class DaoFactory {
	public static ActivityDaoImp getActivityDao() {
		return new ActivityDaoImp();
	}
	public static UserDaoImp getUserDao() {
		return new UserDaoImp();
	}
    public static TopicDaoImp getTopicDao() {
    	return new TopicDaoImp();
    }
    public static ReplyDaoImp getReplyDao() {
    	return new ReplyDaoImp();
    }

}
