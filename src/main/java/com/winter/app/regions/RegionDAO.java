package com.winter.app.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;





//@Controller
//

@Repository
public class RegionDAO {
		
		@Autowired
		private SqlSession sqlSession;
		private final String namespace="com.winter.app.regions.RegionDAO.";
		
		public int delete(RegionDTO regionDTO) {
			
			return sqlSession.delete(namespace+"delete", regionDTO); 
			
		}
		
		
		//update
		public int update(RegionDTO regionDTO) throws Exception {			
			
			return sqlSession.update(namespace+"update",regionDTO);
		}
		
		
		public int addFile(RegionFileDTO regionFileDTO) throws Exception{
			
			return sqlSession.insert(namespace+"addFile",regionFileDTO);
		}
		
		//insert
		public int add(RegionDTO regionDTO) throws Exception {
			
			return sqlSession.insert(namespace+"add",regionDTO);
		}
	
		public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
			System.out.println("df "+ sqlSession);
			
			return sqlSession.selectOne(namespace+"getDetail", regionDTO);
		}

		
		public Long getTotal(Pager pager) throws Exception{
			
			return sqlSession.selectOne(namespace+"getTotal", pager);
			
		}
		
		
		public List<RegionDTO> getList(Pager pager) {		
			
//			sqlSession.selectList(namespace+"getList", pager).forEach(o -> System.out.println(o));
//						
			return sqlSession.selectList(namespace+"getList", pager);
			
										
				
	}
	
}
