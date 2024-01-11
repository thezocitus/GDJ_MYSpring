package com.winter.app.regions;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.Pager;

import oracle.net.aso.m;

@Controller 
@RequestMapping(value = "/regions/*")
public class RegionController {
	//매서드 방식
	
	@Autowired
	private RegionService regionService;
	
	//기본생성자
//	public RegionController() {
//		this.regionDAO = new RegionDAO();
//	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(RegionDTO regionDTO, ModelAndView mv) throws Exception {
		
	 	int result = regionService.update(regionDTO);
	 	
	 	String msg="수정 실패";
		
		if(result>0) {
			msg = "수정 성공"; 
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path","./list");
		
		mv.setViewName("commons/result");
		return mv;
	}
	@RequestMapping(value = "update")
	public String update() {
		
		
		/// WEB-INF/views /. jsp
		return "regions/update";
	}
	
	
	
	@RequestMapping(value = "delete", method=RequestMethod.POST)
	public String delete(RegionDTO regionDTO, Model model) throws Exception {
		int result = this.regionService.delete(regionDTO);
		
		String msg="삭제 실패";
		
		if(result>0) {
			msg = "삭제 성공"; 
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path","./list");
		
		return "commons/result";
	}
		
	
	
	
	
	
	
//		String id = request.getParameter("region_id");
//		String name = request.getParameter("region_name");
//		
//		
//		regionDTO.setRegion_id(Integer.parseInt(id));
//		regionDTO.setRegion_name(name);
//		RegionDTO regionDTO = new RegionDTO();
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(RegionDTO regionDTO, Model model, MultipartFile [] photo) throws Exception{
		int result = this.regionService.add(regionDTO, photo);
		
		
		String msg="등록 실패"; 
		if(result>0) {
			msg = "등록 성공";			
		}
		
		 model.addAttribute("msg", msg);
		 model.addAttribute("path","./list"); // model.addAttribute("path(앞주소)","./list(상세주소)")
		 
		return "commons/result";
	}
	
	
	
	
	@RequestMapping(value = "add")
	public String add() {
		
		
		/// WEB-INF/views /. jsp
		return "regions/add";
	}
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(RegionDTO regionDTO, Model model) throws Exception {
		
		regionDTO = this.regionService.getDetail(regionDTO);
		
//		regionDTO.setRegion_id(null);
		
		model.addAttribute("dto",regionDTO);
		
		return "regions/detail";
	}
//	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Regions List");
//		RegionDAO regionDAO = new RegionDAO();
		List<RegionDTO> ar = regionService.getList(pager);//생성된 데이터
		
		mv.addObject("list", ar);//보낼 데이터
		mv.addObject("pager", pager);
		mv.setViewName("regions/list");
		return mv; //리턴값
	}	
}
