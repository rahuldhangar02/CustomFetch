package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SellInFile {

	@Id
	private int fileId;
	private String fileName;
	private int month;
	private String fileSize;
	private String fileType;
	private int year;
	private String status;
	private String countryName;

	public SellInFile() {
		super();
	}

	public SellInFile(int fileId, String fileName, int month, String fileSize, String fileType, int year, String status,
			String countryName) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.month = month;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.year = year;
		this.status = status;
		this.countryName = countryName;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
