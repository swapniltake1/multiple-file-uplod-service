package com.upload.multiplefiles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upload.multiplefiles.entity.FileEntity;

public interface FileRepository<File> extends JpaRepository<FileEntity, Long> {
}
