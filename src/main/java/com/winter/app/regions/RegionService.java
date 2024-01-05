package com.winter.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO 
@Service
public class RegionService {

	@Autowired
	private RegionDAO regionDAO;

	
	//delete
	
	public int delete(RegionDTO regionDTO ) {
		
		return regionDAO.delete(regionDTO);
	}
	
	//update
	public int update(RegionDTO regionDTO) throws Exception {
		
		return regionDAO.update(regionDTO);
	}
	
	
	//insert
	public int add(RegionDTO regionDTO) throws Exception {
		
		return regionDAO.add(regionDTO);
		
		
	}
	
	
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		
		return regionDAO.getDetail(regionDTO);
	}
	
	
	//list
	public List<RegionDTO> getList() throws Exception {
		List<RegionDTO> ar = this.regionDAO.getList();
	
		return ar;
	
	
	}
}
