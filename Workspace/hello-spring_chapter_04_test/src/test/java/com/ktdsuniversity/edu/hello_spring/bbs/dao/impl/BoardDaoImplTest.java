package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	public void testSelectAllBoardCount() {
		int count = this.boardDao.selectBoardAllCount();
		System.out.println(count);
	}
	public void testSelectAllBoardList() {
		
	}
	

}
