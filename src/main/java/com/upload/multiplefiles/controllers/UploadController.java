package com.upload.multiplefiles.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.upload.multiplefiles.entity.FileEntity;
import com.upload.multiplefiles.service.FileService;

@RestController
public class UploadController {

	@Autowired
	private FileService fileService;

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	private static int fileUploadCount = 0;

	@PostMapping("/upload-files")
	public ResponseEntity<String> uploadFiles(@RequestParam("files") MultipartFile[] files) {

		try {
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					String fileName = file.getOriginalFilename();
					String contentType = file.getContentType();
					Long fileSize = file.getSize();
					byte[] fileData = file.getBytes();

					// Use the injected FileService instance to save the file
					FileEntity savedFile = fileService.saveFile(fileName, contentType, fileSize, fileData);

					fileUploadCount++;

					long fileSizeKB = file.getSize() / 1024;

					// Print file info for each file
					logger.info(fileUploadCount + " File uploaded | File Size: " + fileSizeKB + " KB | File Name: "
							+ file.getOriginalFilename());
				}
			}

			logger.info(fileUploadCount + " Files uploaded Successfully.");

			String message = fileUploadCount + " Files Uploaded";

			return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info("Files not uploaded !! Try Again !!");
			String errorMessage = "File upload failed: " + e.getMessage();
			logger.error(errorMessage, e);
			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
