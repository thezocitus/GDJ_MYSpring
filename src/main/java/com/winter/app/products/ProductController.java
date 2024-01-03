package com.winter.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
	public ModelAndView getList(ModelAndView mv) throws Exception {
		
		List<ProductDTO> ar =this.productDAO.getList();
		mv.addObject("list", ar);
		mv.setViewName("product/list");
		
		return mv;
	 
	}
	
						
	//디테일
	//URL: /product/detail
	//method : get
	//parameter: productNum
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(Long productNum, Model model) throws Exception {
		ProductDTO productDTO = new ProductDTO();		
		productDTO.setProductNum(productNum);		
		productDTO = productDAO.getDetail(productDTO);
				
		model.addAttribute("DTO", productDTO);		
		return "product/detail";
	}
}
