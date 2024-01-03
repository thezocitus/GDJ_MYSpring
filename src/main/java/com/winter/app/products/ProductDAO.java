package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.DBConnector;

public class ProductDAO {
	
	private ProductDTO pD;
	
	public ProductDAO() {
		this.pD = new ProductDTO();
	}

	//상품목록
	//URL METHOD, PRAMITTER
	//URL: /product/list
	//method : get
	//parameter:
			
	public List<ProductDTO> getList() throws Exception {
		Connection con = DBConnector.getConnetor();
		String sql = "INSERT * FROM PRODUCT";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pD = new ProductDTO();
			pD
		}
		
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
