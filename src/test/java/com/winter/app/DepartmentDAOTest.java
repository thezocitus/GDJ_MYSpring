package com.winter.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.departments.DepartmentDTO;


public class DepartmentDAOTest extends MyTest {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Test
	public void getDetailTest() throws Exception {
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println(departmentDTO.getDepartment_id()+" b");
		departmentDTO.setDepartment_id(666);
		System.out.println(departmentDTO.getDepartment_id()+" a");
		departmentDTO = departmentDAO.getDetail(departmentDTO);
		System.out.println(departmentDTO.getDepartment_name()+" r");
		
		assertNotNull(departmentDTO);
		
	}
	@Test
	public void getListTest() throws Exception {
		List<DepartmentDTO> ar = departmentDAO.getList();
		
		assertNotEquals(0, ar);
	}
	

}
