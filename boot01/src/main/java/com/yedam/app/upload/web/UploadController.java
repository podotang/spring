package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;


@Slf4j		//특정메소드에서만 로그출력
@Controller
public class UploadController {
	
	//private String uploadPath = "D:/upload";
	@Value("${file.upload.path}")		//실행시 경로설정
	private String uploadPath;
	
	@GetMapping("getPath")		//경로 잘들어가는지 test용
	@ResponseBody
	public String getPath() {
		return uploadPath;
	}
	
	//classpath:/template/formUpload.html
	@GetMapping("formUpload")	//경로가 페이지
	public void formUploadPage() {	//void쓰면 리턴없음 경로가 return대상
	}
	
	// multipart/form-data 는 post로만 사용가능 @RequestPart가 처리해줌
	// form의 name 값이 매개변수 images 로 똑같이같다 중요리~~~
	// multipart/form-data 데이터 타입 자동인코딩됨 굿~~
	@PostMapping("uploadForm")	//fomrUpload.html부분에 multiple 있어서 []배열로리턴선언
	public String formUploadFile(@RequestPart MultipartFile[] images) {
		// log.info(images[0].getOriginalFilename());	 
		for(MultipartFile image : images) {

//			log.warn(image.getContentType());					// 개별 파일의 종류
//			log.warn(image.getOriginalFilename());				// 사용자가 넘겨준 실제 파일이름
//			log.warn(String.valueOf(image.getSize()));		//파일 크기
			
			//1) 원래 파일이름
			String fileName = image.getOriginalFilename();
			
			//2) 실제 저장할 경로를 생성	: 서버의 업로드 경로 + 파일이름
			String saveName = uploadPath + File.separator + fileName;
			log.debug("saveName : " + saveName);
			
			Path savePath = Paths.get(saveName);
			
			//3) 파일 작성(파일 업로드)
			try {
				image.transferTo(savePath);
			}  catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return "formUpload";
	}
	
	
	@GetMapping("upload")
	public void uploadPage() {}
	
	@PostMapping("/uploadsAjax")
	@ResponseBody
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) {
	    
		List<String> imageList = new ArrayList<>();
		
	    for(MultipartFile uploadFile : uploadFiles){
	    	if(uploadFile.getContentType().startsWith("image") == false){	//이미지로 시작하지않으면 오류처리
	    		System.err.println("this file is not image type");
	    		return null;
	        }
	  
	        String originalName = uploadFile.getOriginalFilename();
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
	        
	        System.out.println("fileName : " + fileName);
	    
	        //날짜 폴더 생성
	        String folderPath = makeFolder();
	        //UUID	 : math.random() 사용안하고 고유한 랜덤값줄때
	        String uuid = UUID.randomUUID().toString();
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분
	        
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName;
	        
	        String saveName = uploadPath + File.separator + uploadFileName;
	        
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	uploadFile.transferTo(savePath);
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        
	        
	        // DB에 해당 경로 저장
	        
	        
	        // 1) 사용자가 업로드할 때 사용한 파일명
	        
	        
	        // 2) 실제 서버에 업로드할 때 사용한 경로
	        
	        
	        
	        
	        imageList.add(setImagePath(uploadFileName));
	     }
	    
	    return imageList;
	}
	
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator);
		File uploadPathFoler = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}
	
	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}
	
	
	
	
	
	
}
