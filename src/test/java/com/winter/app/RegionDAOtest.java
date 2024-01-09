package com.winter.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;
import com.winter.app.util.Pager;

public class RegionDAOtest extends MyTest{
	
	@Autowired
	private RegionDAO regionDAO;
	
	
//	@Test
	public void getListTest () {
		Pager pager = new Pager();
		pager.setPage(1L);
		pager.makeRow();
		List<RegionDTO> ar = regionDAO.getList(pager);
		System.out.println(ar.get(0).getRegion_id());
		
		
		assertEquals(10, ar.size());		
		
	}
	
		
//	@Test	
	public void getDetailTset() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
	 	regionDTO.setRegion_id(1);
	 	regionDTO = regionDAO.getDetail(regionDTO);
	
	 	assertNotNull(regionDTO);
	}
	
//	@Test
//	public void addTest() throws Exception {
//		RegionDTO regionDTO = new RegionDTO();
//	 	regionDTO.setRegion_name("HEAVEN");
//	 	regionDTO.setRegion_id(666);
//	 	int result = regionDAO.add(regionDTO);
//	
//	 	assertEquals(1,result);
//	}

	@Test
	public void addTest() throws Exception{
		RegionDTO regionDTO = new RegionDTO();
	 	for(int i = 0 ; i < 100 ; i++) {
	 		regionDTO.setRegion_name("Hell"+i);
		 	regionDTO.setRegion_id(100+i*3);
	 		
	 		int result = regionDAO.add(regionDTO);
	 	}
	
	 	
	}
	
	
//	@Test
	public void updateTest() throws Exception{
		RegionDTO regionDTO = new RegionDTO();
	 	regionDTO.setRegion_name("hell");
	 	regionDTO.setRegion_id(666);
	 	int result = regionDAO.update(regionDTO);
	 	
	 	
	 	assertEquals(1,result);
	}
//	@Test
	public void delectTest() {
		RegionDTO regionDTO = new RegionDTO();
	 	regionDTO.setRegion_id(209);
	 	
	 	int result = regionDAO.delete(regionDTO);
	 	
	 	
	 	assertEquals(1,result);
		
	}

}
