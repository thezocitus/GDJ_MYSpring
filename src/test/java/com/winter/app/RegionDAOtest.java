package com.winter.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;

public class RegionDAOtest extends MyTest{
	
	@Autowired
	private RegionDAO regionDAO;
	
	
	@Test
	public void getListTest () {
		
		List<RegionDTO> ar = regionDAO.getList();
		
		assertNotEquals(0, ar.size());		
		
	}
	
	
	
	
	@Test	
	public void getDetailTset() throws Exception {
		RegionDTO regionDTO = new RegionDTO();
	 	regionDTO.setRegion_id(1);
	 	regionDTO = regionDAO.getDetail(regionDTO);
	
	 	assertNotNull(regionDTO);
	}

}
