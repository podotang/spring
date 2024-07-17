package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;


@Slf4j		//특정메소드에서만 로그출력
@Controller
public class UploadController {
	
	//private String uploadPath = "D:/upload";
	@Value("${file.upload.path}")
	private String uploadPath;
	
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
	
	
	
	
	
	
	
	
	
}
