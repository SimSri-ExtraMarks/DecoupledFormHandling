package com.formHandling.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.formHandling.backend.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			// validation
			/*
			 * if(file.isEmpty()) { return
			 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
			 * body("Request must contain file"); }
			 * if(!file.getContentType().equals("image/jpeg")) { return
			 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
			 * body("Only JPEG type images supported"); }
			 */
			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
				//Static Path
				//return ResponseEntity.ok("File Uploaded Successfully");
	return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());		
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
}