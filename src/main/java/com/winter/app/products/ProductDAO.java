package com.winter.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class ProductDAO {

	//상품목록
	//URL METHOD, PRAMITTER
	//URL: /product/list
	//method : get
	//parameter:
			
	public List<ProductDTO> getList() {
	
		return null;
	}
	
	//디테일
	//URL: /product/list
	//method : get
	//parameter: productNum
	
	public ProductDTO getDetail(ProductDTO productDTO) {
		
		return null;				
	}
	
	//디테일
	//URL: /product/list
	//method : get
	//parameter: productNum
	
	
	public int doAdd(ProductDTO productDTO) {
		
		return 0;
	}

		
	public int doUpdate(ProductDTO productDAO) {
	
		return 0;
		
	}
	
	
	public int doDelect(ProductDTO productDTO) {
	
		return 0;
		
	}
	
}
