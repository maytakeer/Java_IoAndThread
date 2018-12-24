package com.ushine.xuexi.service.impl;

/**
 * 
 * @author Lee
 *
 */
public interface IUserService {

	/**
	 * 系统初始化状态常量:1
	 */
	int SYSTEM_STATUS_INIT = 1;
	
	/**
	 * 
	 * @param user
	 */
	void createUser(Object user);
	
	/**
	 * 
	 * @param ids
	 */
	void queryUser(int[] ids);
}
