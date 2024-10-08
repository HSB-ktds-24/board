package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardListVO getAllBoard() {
		//게시글 목록 화면에 데이터를 전송해주기 위해서 게시글의 건수와 목록을 조회해 반환시킨다.
		
		//1.게시글 건수를 조회
		
		int boardCount = this.boardDao.selectBoardAllCount();
		
		//2.  ||  목록 조회
		
		List<BoardVO> boardList = this.boardDao.selectAllBoard();
		
		//3. 건수와 목록을 할당
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardCnt(boardCount);
		boardListVO.setBoardlist(boardList);
				
		//4. BoardListVO 인스턴스를 반환
		return null;
	}

}
