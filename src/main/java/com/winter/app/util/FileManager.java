package com.winter.app.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public boolean fileDelete(String path, String fileName) throws Exception{
		
		
		File file = new File(path, fileName);
		return file.delete();
		
	}
	
	
	public String fileSave(String path, MultipartFile file) throws Exception{
		
		System.out.println(path+" : FileManager.fileSave");
		
		//path : real path
		File f = new File(path);
		
//		f = new File(f,path);
//		
		if(f.isFile()) {
			throw new Exception();
//			return
		}
		System.out.println("filemanager check");
		if(!f.exists()) {
			f.mkdirs();
		}
	//2. 저장할 파일명으로 저장할 것인가??
		//a.시간 이용
		
//		Calendar ca = Calendar.getInstance();
//		String fileName=ca.getTimeInMillis()+"_"+file.getOriginalFilename(); //MultipartFile file
//		System.out.println(fileName);
//		//b. UUID
		String fileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println(fileName);
		
	//3. 파일을 저장
		f=new File(f, fileName);
		// a.FileCopyUtils 클래스 이용
		//   FileCopyUtils.copy(file.getBytes(), f);
	
		//b.MultipaertFile의 transferTo 사용
		
		file.transferTo(f);
		
		return fileName;
		
	}
	
	
	
}
