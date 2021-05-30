package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CustomMapper {

	public static List<SellInFileDto> toDto(List<String> sellInFileList) {
		List<SellInFileDto> sellInFileDtoList = new ArrayList<>();
		sellInFileList.stream().forEach(obj -> {
			SellInFileDto sellInFileDto = new SellInFileDto();
			sellInFileDto.setFileType(obj);
			sellInFileDtoList.add(sellInFileDto);
		});
		return sellInFileDtoList;
	}

}
