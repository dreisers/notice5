package dev.blog.notice5;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;

@Controller
public class NoticeCont {
	
	@Autowired
	NoticeDAO dao;
		
	public NoticeCont() {
		System.out.println("--- NoticeCont 생성");
	}
	
	//결과확인
	@RequestMapping(value="/notice/create.do", method=RequestMethod.GET)
	public ModelAndView createForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/createForm");
		return mav;
	}//createForm end
	
	@RequestMapping(value="/notice/create.do", method=RequestMethod.POST)
	public ModelAndView createProc(NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/notice/list.do");
		int count = dao.create(dto);
		mav.addObject("count", count);
		return mav;
	}//createProc end
	
	@RequestMapping("/notice/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/list");
		ArrayList<NoticeDTO> list = dao.list();
		mav.addObject("list", list);
		return mav;
	}//list end
	
	@RequestMapping(value="/notice/read.do", method=RequestMethod.GET)
	ModelAndView read(NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/read");
		dto = dao.read(dto);
		mav.addObject("dto", dto);
		//mav.addObject("dto", dao.read(dto));
		return mav;
	}//read end
	
	@RequestMapping(value="/notice/update.do", method=RequestMethod.GET)
	public ModelAndView updateForm(NoticeDTO dto) { // url뒤에 있는 parameter 값을 dto로 변환해서 가져온다 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/updateForm"); // 다음페이지를 ("")으로 지정
		dto = dao.read(dto); // dto에 read메소드로 데이터를 불러와 저장 
		mav.addObject("dto", dto); // dto값 저장
		return mav;
	}
	
	@RequestMapping(value="/notice/update.do", method=RequestMethod.POST)
	public ModelAndView updateProc(NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/notice/list.do");
		int count = dao.update(dto);
		return mav;
	}
	
	@RequestMapping(value="/notice/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteForm(NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/deleteForm");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping(value="/notice/delete.do", method=RequestMethod.POST)
	public ModelAndView deleteProc(NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/notice/list.do");
		int count = dao.delete(dto);
		return mav;
	}
	
	@RequestMapping(value="/notice/search.do", method=RequestMethod.GET)
	public ModelAndView search(String col, String word) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/list");
		ArrayList<NoticeDTO> list = dao.search(col, word);
		mav.addObject("list", list);
		return mav;
	}//search end 
	
}//class end
