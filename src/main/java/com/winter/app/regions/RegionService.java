package com.winter.app.regions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

//DAO 
@Service
public class RegionService {

	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	//내장 객체 중 application
	private ServletContext servletContext;

	
	//delete
	
	public int delete(RegionDTO regionDTO ) {
		
		return regionDAO.delete(regionDTO);
	}
	
	//update
	public int update(RegionDTO regionDTO) throws Exception {
		
		return regionDAO.update(regionDTO);
	}
	
	
	//insert
	public int add(RegionDTO regionDTO, MultipartFile file) throws Exception {
			
			int result = regionDAO.add(regionDTO);
		//1. 어디에 저장할 것 인가??
			String path = servletContext.getRealPath( "/resources/upload");
			
			System.out.println(path);			
		
			File f = new File(path, "regions");
			
			
			
			if(!f.exists()) {
				f.mkdirs();
			}
		//2. 저장할 파일명으로 저장할 것인가??
			//a.시간 이용
			Calendar ca = Calendar.getInstance();
			String fileName=ca.getTimeInMillis()+"_"+file.getOriginalFilename();
			System.out.println(fileName);
			//b. UUID
			fileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
			System.out.println(fileName);
			
		//3. 파일을 저장
			// a.FileCopyUtils 클래스 이용
			f=new File(f, fileName);
			FileCopyUtils.copy(file.getBytes(), f);
									
		//4. DB에 정보 저장
			RegionFileDTO dto = new RegionFileDTO();
			dto.setFileName(fileName);
			dto.setOrigName(file.getOriginalFilename());
			dto.setRegion_id(regionDTO.getRegion_id());
			result = regionDAO.addFile(dto);
			return  result;
			/* regionDAO.add(regionDTO); */
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
