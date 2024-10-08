package com.ktdsuniversity.edu.hello_spring.bbs.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;
import com.ktdsuniversity.edu.hello_spring.common.beans.FileHandler;

@Controller
public class BoardController {

	@Autowired
	private FileHandler fileHandler;
	@Autowired
	private BoardService boadService;
	
	@GetMapping("/board/list")
	public String viewBoardList(Model model) {
		BoardListVO boardListVO =this.boadService.getAllBoard();
		model.addAttribute("boardListVO",boardListVO);
		return "board/boardlist";
	}
	
	@GetMapping("/board/write")
	public String viewBoardWritePage() {
		return "board/boardwrite";
	}
	
	@PostMapping("/board/write")
	public String doCreateNewBoard(WriteBoardVO writeBoardVO){
		
		
		boolean isCreated = this.boadService.createNewBoard(writeBoardVO);
		String result = isCreated?"게시글이 등록되었습니다.":"게시글 등록에 실패하였습니다.";
		System.out.println(result);
		
		return "redirect:/board/list";
		// redirect = 지정 url 재요청
	}
	
	@GetMapping("/board/view")
	public String viewOneBaord(Model model, @RequestParam int id) {
		BoardVO boardVO =this.boadService.getOneBoard(id,true);
		
		model.addAttribute("BoardVO",boardVO);
		return "board/boardview";
	}
	
	@GetMapping("/board/modify/{id}")
	public String viewBoardModifyPage(Model model,@PathVariable int id){
		BoardVO boardVO = this.boadService.getOneBoard(id, false);
		model.addAttribute("BoardVO",boardVO);
		return "board/boardmodify";
	}
	
	@PostMapping("/board/modify/{id}")
	public String doModifyOneBoard(@PathVariable int id, ModifyBoardVO modifyboardVO, Model model) {
		
		modifyboardVO.setId(id);
		
		boolean isUpdated = this.boadService.updateOneBoard(modifyboardVO);
		
		if(isUpdated) {
			return "redirect:/board/view?id="+id;
		}
		else {
			model.addAttribute("boardVO", modifyboardVO);
			return "board/boardmodify";
		}
	}
	
	@GetMapping("/board/delete/{id}")
	public String deleteOneBoard(@PathVariable int id) {
		
		boolean isDeleted = this.boadService.deleteOneBoard(id);
		
		if(isDeleted) {
		return "redirect:/board/list";
		}
		else {
			return "redirect:/board/view?id="+id;
		}
		
	}
	
	@GetMapping("/board/file/download/{id}")
	public ResponseEntity<Resource> doDounloadFile(@PathVariable int id){
		
		BoardVO baordVO = this.boadService.getOneBoard(id, false);
		return this.fileHandler.downloadFile(baordVO.getFileName(), baordVO.getOriginFileName());
		
	}
	
	

}
