package com.winter.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.util.DBConnector;

public class DepartmentDAO {
	
	
	public int update(DepartmentDTO departmentDTO) throws Exception{
		Connection con = DBConnector.getConnetor();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	
	public int add(DepartmentDTO departmentDTO) throws Exception {
		Connection con = DBConnector.getConnetor();
		
		String sql = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		st.setString(2, departmentDTO.getDepartment_name());
		st.setInt(3, departmentDTO.getManager_id());
		st.setInt(4,departmentDTO.getLocation_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	public DepartmentDTO getdetail(DepartmentDTO departmentDTO) throws Exception {
		Connection con = DBConnector.getConnetor();
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO resultDTO = null;
		
		if(rs.next()) {
			resultDTO = new DepartmentDTO();
			resultDTO.setDepartment_id(rs.getInt("department_id"));
			resultDTO.setDepartment_name(rs.getString("department_name"));
			resultDTO.setManager_id(rs.getInt("manager_id"));
			resultDTO.setLocation_id(rs.getInt("location_id"));			
		}
				
		DBConnector.disConnect(rs ,st, con);
		
		return resultDTO;		
		
	}
	

	public List<DepartmentDTO> getList() throws Exception {
		//DB접속 후 부서테이블의모든 정보를 출력
		Connection con = DBConnector.getConnetor();		
//		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";		
		String sql = "SELECT * FROM DEPARTMENTS";		
		//4. SQL문 미리 전송
		PreparedStatement st =con.prepareStatement(sql);		
		//5. ? 값 세팅
//		st.setInt(0, departmentDTO.getDepartment_id());
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		System.out.println(rs);	
		List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();		
		while(rs.next()) {
			DepartmentDTO resultDTO = new DepartmentDTO();
			resultDTO.setDepartment_id(rs.getInt("department_id"));
			resultDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			resultDTO.setManager_id(rs.getInt("MANAGER_ID"));
			resultDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(resultDTO);				
		}		
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
		
	}

}
