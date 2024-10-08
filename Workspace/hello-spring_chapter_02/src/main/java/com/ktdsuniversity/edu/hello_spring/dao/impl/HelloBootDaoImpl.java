package com.ktdsuniversity.edu.hello_spring.dao.impl;


import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.dao.HelloBootDao;

/* DB와 통신을 수행하는 클래서
 * 서비스가 관라하는 클래스
 * --> @Service가 @Repository 대해서 트랜잭션을 수행
 * */

@Repository
public class HelloBootDaoImpl implements HelloBootDao{

	
	public HelloBootDaoImpl() {
		System.out.println("HelloBootDaoImpl가 인스턴스를 생성");
	}
	@Override
	public String selectMessage() {
	
		return "hi";
	}

}
