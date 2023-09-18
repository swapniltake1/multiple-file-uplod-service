package com.upload.multiplefiles.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "file_name", nullable = false)
	private String fileName;

	@Column(name = "content_type", nullable = false)
	private String contentType;

	@Column(name = "file_size", nullable = false)
	private Long fileSize;

	@Lob
	@Column(name = "file_data", nullable = false)
	private byte[] fileData;

	public FileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileEntity(Long id, String fileName, String contentType, Long fileSize, byte[] fileData) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.contentType = contentType;
		this.fileSize = fileSize;
		this.fileData = fileData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", fileName=" + fileName + ", contentType=" + contentType + ", fileSize=" + fileSize
				+ ", fileData=" + Arrays.toString(fileData) + "]";
	}

}
