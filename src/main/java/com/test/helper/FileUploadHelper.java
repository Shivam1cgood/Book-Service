package com.test.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR="C:\\Users\\Shivam\\Documents\\workspace-sts\\bootrestbook\\src\\main\\resources\\static\\image";
//	NOTE : "static/image" path inside resource folder
	
	
	public final String UPLOAD_DIR= new ClassPathResource("/static/image/").getFile().getAbsolutePath();
	
//	public final String UPLOAD_DIR = Paths.get(new ClassPathResource("static").getURI()).toString();

	
	
	
	public FileUploadHelper() throws IOException {
	    File directory = new File(UPLOAD_DIR);
	    if (!directory.exists()) {
	        directory.mkdirs(); // Create the directory if it doesn't exist
	    }
	}


	public boolean uploadFile(MultipartFile multipartFile) {
		
		
		boolean f = false;
		
		try {
//			InputStream is = multipartFile.getInputStream();
//			byte[] data = new byte[is.available()];
//			
//			is.read(data);
//			
////			write data
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
//		NOTE:	One Liner for above
			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//			
			f= true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
