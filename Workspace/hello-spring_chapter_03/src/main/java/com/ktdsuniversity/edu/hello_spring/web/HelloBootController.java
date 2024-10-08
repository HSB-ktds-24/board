package com.ktdsuniversity.edu.hello_spring.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.hello_spring.serive.HelloBootService;

@Controller
public class HelloBootController {

//	public HelloBootController(){
//		System.out.println("@Controller가 적용된 클래스는 스프링이 직접 인스턴스로 만들어서 빈 컨테이너에 저장됨");
//	}
	
	/*
	 * di: 스프링 빈에 있는 인스턴스를 주입한다
	 * 멤버변수의 탕비과 스프링 빈 컨테이너에 있는 인스턴스의 타입이 같은 것만 주입한다.
	 * */
	private HelloBootService helloBootService;
	
	@GetMapping("/print") /*localhost:8080/print*/
	public void printConsoleURL() {
		System.out.println("브라우저에 의해 호출됨");
	}
	
	@GetMapping("/text") 
	public ResponseEntity<String> printText(){
		return new ResponseEntity<>("브라우저로 텍스트를 전달",HttpStatus.NOT_FOUND);
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/html") 
	public ResponseEntity<String> printHtml(){
		return new ResponseEntity<>(
			"""
			<!DOCTYPE html>
			<html>
				<head>
					<title>Spring Test</title>
				<body>
					<h1>테스트</h1>
				</body>
			</html>
			"""
				,HttpStatus.OK);
	}
	/*
	 http://localhost:8080/jsp로 브라우저가 요청하면
	 스프링 컨트롤러는 /WEB-INF/views/helloJsp.jsp를 읽어와서
	 html로 변환 후 브라우저에 돌려준다.
	 */
	@GetMapping("/jsp") 
	public String viewJSP() {
		return "helloJsp";
	}
	@GetMapping("/jsp2") 
	public ModelAndView viewJSPWithModelAndView() {
		/*
		 *model: jsp에 보내질 데이터
		 *view: 브라우에게 보여줄 화면 
		 */
		ModelAndView view = new ModelAndView("helloJsp");
		view.addObject("applicationName", "BOO!");
		return view;
	}
	
	@GetMapping("/jsp3") 
	public String viewJSPWithModel(Model model) {
		String greetingMessage=this.helloBootService.getGreetingMessage();
		model.addAttribute("applicationName", greetingMessage);
		return "helloJsp";
	}
}
