package com.winter.app.regions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping(value = "/regions/*")
public class RegionController {
	//매서드 방식
	private RegionDAO regionDAO;
	
	//기본생성자
	public RegionController() {
		this.regionDAO = new RegionDAO();
	}
	
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) throws Exception{
		String id = request.getParameter("region_id");
		String name = request.getParameter("region_name");
		
		RegionDTO regionDTO = new RegionDTO();
		
		regionDTO.setRegion_id(Integer.parseInt(id));
		regionDTO.setRegion_name(name);
		
		int result = this.regionDAO.add(regionDTO);
		
		String msg="등록 실패"; 
		if(result>0) {
			msg = "등록 성공";			
		}
		
		 request.setAttribute("msg", msg);
		 request.setAttribute("path","./list");
		 
		return "commons/result";
	}
	
	
	
	
	@RequestMapping(value = "add")
	public String add() {
		
		
		/// WEB-INF/views /. jsp
		return "regions/add";
	}
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception {
		
		RegionDAO regionDAO = new RegionDAO();
		RegionDTO regionDTO = new RegionDTO();
		String id = request.getParameter("region_id");
		
		regionDTO.setRegion_id(Integer.parseInt(id));
		
		regionDTO = regionDAO.getDetail(regionDTO);
		
		request.setAttribute("dto", regionDTO);
		
		return "regions/detail";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		System.out.println("Regions List");
		RegionDAO regionDAO = new RegionDAO();
		List<RegionDTO> ar = regionDAO.getList();//생성된 데이터
		System.out.println(ar.size());
		
		mv.addObject("list", ar);//보낼 데이터
		mv.setViewName("regions/list");
		return mv; //리턴값
	}	
}
