package com.ktdsuniversity.edu.do_to_list.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.do_to_list.bbs.dao.ScheduleDao;
import com.ktdsuniversity.edu.do_to_list.bbs.vo.ScheduleVO;
import com.ktdsuniversity.edu.do_to_list.bbs.vo.ScheduleWriteVO;

@Repository
public class ScheduleDaoImpl extends SqlSessionDaoSupport implements ScheduleDao{

	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertSchedule(ScheduleWriteVO scheduleWriteVO) {
		
		return this.getSqlSession().insert("com.ktdsuniversity.edu.do_to_list.bbs.dao.ScheduleDao.insertSchedule", scheduleWriteVO);
	}

	@Override
	public int deleteSchedule(int id) {
		return this.getSqlSession().delete("com.ktdsuniversity.edu.do_to_list.bbs.dao.ScheduleDao.deleteSchedule", id);
	}

	@Override
	public List<ScheduleVO> selectAllSchedule() {
		return this.getSqlSession().selectList("com.ktdsuniversity.edu.do_to_list.bbs.dao.ScheduleDao.selectAllSchedule");
	}

	@Override
	public int updateSchedule(int id) {
		return this.getSqlSession().update("com.ktdsuniversity.edu.do_to_list.bbs.dao.ScheduleDao.updateSchedule", id);
	}
	
	


}
