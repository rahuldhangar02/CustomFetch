package com.example.demo;

import java.util.List;

public class SellInFileDto {

	private String fileType;
	private List<FileDetailsDto> actions;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public List<FileDetailsDto> getActions() {
		return actions;
	}

	public void setActions(List<FileDetailsDto> actions) {
		this.actions = actions;
	}

}
