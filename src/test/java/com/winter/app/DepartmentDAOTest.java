package com.winter.app;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.departments.DepartmentDTO;


public class DepartmentDAOTest extends MyTest {

	@Autowired
	private DepartmentDAO departmentDAO;
	
//	@Test
	public void getDetailTest() throws Exception {
		
		DepartmentDTO departmentDTO = new DepartmentDTO();		
		departmentDTO.setDepartment_id(666);		
		departmentDTO = departmentDAO.getDetail(departmentDTO);		
		assertNotNull(departmentDTO);
		
	}
//	@Test
	public void getListTest() throws Exception {
		List<DepartmentDTO> ar = departmentDAO.getList();
		
		assertNotEquals(0, ar);
	}
//	@Test
	public void addTest() throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();			
		departmentDTO.setDepartment_id(666);	
		departmentDTO.setDepartment_name("HEAVEN");
		departmentDTO.setManager_id(200);
		departmentDTO.setLocation_id(1700);
		
		int result = departmentDAO.add(departmentDTO);	
		assertEquals(1,result);
		
	}
	
	
//	@Test
	public void delete() throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();		
		departmentDTO.setDepartment_id(777);		
		int result = departmentDAO.delete(departmentDTO);		
		assertEquals(1,result);
	}
	@Test
	public void updateTest() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();			
		departmentDTO.setDepartment_id(666);	
		departmentDTO.setDepartment_name("HELL");
		departmentDTO.setManager_id(200);
		departmentDTO.setLocation_id(1700);
		
		int result = departmentDAO.update(departmentDTO);		
		assertEquals(1,result);
	}
	
	
}
