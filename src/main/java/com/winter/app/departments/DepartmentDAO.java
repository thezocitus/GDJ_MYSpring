package com.winter.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnector;

@Repository
public class DepartmentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.winter.app.departments.DepartmentDAO.";
	
//	public int update(DepartmentDTO departmentDTO) throws Exception{
//		Connection con = DBConnector.getConnetor();
//		
//		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? WHERE DEPARTMENT_ID=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setString(1, departmentDTO.getDepartment_name());
//		st.setInt(2, departmentDTO.getManager_id());
//		st.setInt(3, departmentDTO.getLocation_id());
//		st.setInt(4, departmentDTO.getDepartment_id());
//		
//		int result = st.executeUpdate();
//		
//		DBConnector.disConnect(st, con);
//		
//		return result;
//		
//	}
//	
//	
//	public int add(DepartmentDTO departmentDTO) throws Exception {
//		Connection con = DBConnector.getConnetor();
//		
//		String sql = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
//		
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setInt(1, departmentDTO.getDepartment_id());
//		st.setString(2, departmentDTO.getDepartment_name());
//		st.setInt(3, departmentDTO.getManager_id());
//		st.setInt(4,departmentDTO.getLocation_id());
//		
//		int result = st.executeUpdate();
//		
//		DBConnector.disConnect(st, con);
//		
//		return result;
//		
//	}
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
			
		return sqlSession.selectOne(namespace+"getDetail", departmentDTO);
		
	}
	

	public List<DepartmentDTO> getList() throws Exception {
			
		return sqlSession.selectList(namespace+"getList");
		
		
	}

}
