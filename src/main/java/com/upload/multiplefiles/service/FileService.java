package com.upload.multiplefiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upload.multiplefiles.dao.FileRepository;
import com.upload.multiplefiles.entity.FileEntity;

@Service
public class FileService {

	@Autowired
	private FileRepository<FileEntity> fileRepository;

	public FileEntity saveFile(String fileName, String contentType, Long fileSize, byte[] fileData) {
		FileEntity file = new FileEntity();
		file.setFileName(fileName);
		file.setContentType(contentType);
		file.setFileSize(fileSize);
		file.setFileData(fileData);
		return fileRepository.save(file);
	}
}
