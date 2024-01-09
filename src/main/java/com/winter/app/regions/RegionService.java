package com.winter.app.regions;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

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
	public List<RegionDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		Long totalCount = regionDAO.getTotal(pager);
		System.out.println(totalCount);
		
		pager.makeNum(totalCount);
				
		/////////////////////////////////////////////////////
		//페이지 계산 코드
		//1.총 페이지의 수
//		
//		Long totalPage=0L;
//		
//		totalPage = totalCount/pager.getPerPage();
//		if(totalCount%pager.getPerPage() > 0) {
//			totalPage++;
//		}		
//		
//		pager.setTotalPage(totalPage);
//		
//		//3.총 블럭의 수
//		Long perBlock=5L;
//		Long totalBlock=0L;
//		
//		totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock !=0) {
//			totalBlock++;
//		}
//		
//		//3. page의 값으로 현제의 블럭 번호 찾기 
//		Long curBlock=0L;
//		
//		curBlock=pager.getPage()/perBlock;
//		 
//		if(pager.getPage()%perBlock !=0) {
//			curBlock++;
//		}
//		//4. 현제 블럭번호로 시작번호와 끝 번호 구하기
//		Long startNum=0L;
//		Long lastNum= curBlock*perBlock;;		
//		startNum = lastNum-perBlock+1;
//		
//		pager.setLastNum(lastNum);
//		pager.setStartNum(startNum);
//		
//		//이전, 다음 블럭 유뮤 체크
//		if(curBlock==1) {
//			pager.setStart(true);
//		}
//		
//		if(curBlock==totalBlock) {
//			pager.setLastNum(totalPage);
//			pager.setLast(true);
//		}
		
		//////////////////////////////////////////////////////////
		
		List<RegionDTO> ar = this.regionDAO.getList(pager);
		System.out.println("check");
		return ar;	
	
	}
}
