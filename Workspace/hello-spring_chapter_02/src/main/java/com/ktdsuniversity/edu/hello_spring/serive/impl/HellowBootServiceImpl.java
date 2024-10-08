package com.ktdsuniversity.edu.hello_spring.serive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.dao.HelloBootDao;
import com.ktdsuniversity.edu.hello_spring.serive.HelloBootService;

@Service
public class HellowBootServiceImpl implements HelloBootService{


	@Autowired
	private HelloBootDao helloBooDao;
	
	public HellowBootServiceImpl() {
		System.out.println("HelloBootDaoImpl가 인스턴스를 생성");
	}
	@Override
	public String getGreetingMessage() {
		String message = this.helloBooDao.selectMessage();
		return "hi" + message;
	}

}
