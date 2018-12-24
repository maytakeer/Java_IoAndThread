package com.ushine.xuexi.service.impl;


public class UserServiceImpl implements IUserService {

	private int count;
	
	private static int index;
	
	@Override
	public void createUser(Object user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryUser(int[] ids) {
		//错误的做法，所编码中禁止对数据库执行循环查询
		//尽量执行少的sql语句
		for(int id : ids){
//			dao.findById(id);
		}
		//查询分页,20W,需要5-10分钟
		
		//批量导入：尽量利用数据库的批量导入工具实现
		//insert 单条语句，不可用,单条事务不可用 效率很低
		// 分析数据量，几年内到达的总量与数据表结构的关系，合理规避第三范式，
		//查询条件必须索引优先，尽量不要select * 
		//多索引，优先选择更快降低数据量的索引
		//分表分库 
	}

}
