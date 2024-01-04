package com.winter.app.region;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;

public class RegionDAOtest extends MyTest{
	
	@Autowired
	private RegionDAO regionDAO;
	
	@Test	
	public void getDetailTset() {
		RegionDTO regionDTO = new RegionDTO();
	 	regionDTO.setRegion_id(1);
	 	regionDTO = regionDAO.getDetail(regionDTO);
	
	 	assertNotNull(regionDTO);
	}

}
