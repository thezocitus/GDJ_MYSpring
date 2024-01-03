package com.winter.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/product/*")
public class ProductController {

	private ProductDAO productDAO;
	public ProductController() {
		this.productDAO = new ProductDAO();
	}
	
	//상품목록
		//URL METHOD, PRAMITTER
		//URL: /product/list
		//method : get
		//parameter:
				
	@RequestMapping(value= "list", method=RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) {
	 
		List<ProductDTO> ar =this.productDAO.getList();
		mv.addObject("list", ar);
		mv.setViewName("list");
		
		return mv;
	 
	}
	
			
			
	//디테일
	//URL: /product/detail
	//method : get
	//parameter: productNum
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ModelAndView mv) {
		ProductDTO productDTO = new ProductDTO();
		
		mv.addObject("dto", productDTO);
		mv.setViewName("detail");
		return mv;
	}
}
