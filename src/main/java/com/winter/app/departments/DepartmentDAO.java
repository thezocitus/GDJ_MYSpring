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
	
	public int delete(DepartmentDTO departmentDTO) throws Exception{
		
		return sqlSession.delete(namespace+"delete",departmentDTO);
	}
	
	public int update(DepartmentDTO departmentDTO) throws Exception{		
		
		return sqlSession.update(namespace+"update",departmentDTO);
		
	}
	
	
	public int add(DepartmentDTO departmentDTO) throws Exception {		
		
		return sqlSession.insert(namespace+"add",departmentDTO);
		
	}
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
			
		return sqlSession.selectOne(namespace+"getDetail", departmentDTO);
		
	}
	

	public List<DepartmentDTO> getList() throws Exception {
			
		return sqlSession.selectList(namespace+"getList");
		
		
	}

}
