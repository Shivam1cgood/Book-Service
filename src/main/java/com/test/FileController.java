package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.helper.FileUploadHelper;

@RestController
public class FileController {
	
	@Autowired
	private FileUploadHelper fileUpoadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file){
//		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		
		try {
			
			
//		validation
			if(file.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("File must not be empty");
			}
			
			if(!file.getContentType().equals("image/png")){
				return ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("File type must be png");
			}
		
//		file upload code...
			
			boolean f = fileUpoadHelper.uploadFile(file);
			
			if(f) {
//				return ResponseEntity.ok("File uploaded succesfully");
				
				
				return ResponseEntity.ok(
					    ServletUriComponentsBuilder.fromCurrentContextPath()
					        .path("/image/")
					        .path(file.getOriginalFilename())
					        .toUriString()
					);

			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Something went wrong! Try again!");
	}

}
