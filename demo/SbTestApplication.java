package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbTestApplication.class, args);
	}

	@Autowired
	private SellInFileRepository sellInFileRepository;

	@GetMapping("/insert")
	public String insert() {

		List<SellInFile> sellInFileList = Arrays.asList(
				new SellInFile(101, "SALESCOND_TC_ALL_NEW1", 5, "12423", "Sales Condition", 2021, "Success", "France"),
				new SellInFile(102, "SALESCOND_TC_ALL_NEW1", 5, "12423", "Sales Condition", 2021, "Success", "France"),
				new SellInFile(103, "SALESCOND_TC_ALL_NEW1", 5, "32423", "Sales Condition", 2021, "Success", "France"),
				new SellInFile(104, "SALESCOND_TC_ALL_NEW2", 6, "56423", "Sales Condition", 2021, "Success", "France"),
				new SellInFile(105, "SALESCOND_TC_ALL_NEW2", 6, "36423", "Sales Condition", 2021, "Success", "France"),
				new SellInFile(106, "SALESCOND_TC_ALL_NEW2", 6, "356423", "Sales Condition", 2021, "Success", "France")

		);
		sellInFileRepository.saveAll(sellInFileList);
		return "success";
	}

	@GetMapping("/get/{month}/{year}")
	public List<SellInFileDto> getDetail(@PathVariable int month, @PathVariable int year) {

		List<String> fileTypeList = sellInFileRepository.getUniqueFileTypeByMonthAndYear(month, year);

//		List<SellInFileDto> SellInFileDtoList = CustomMapper.toDto(fileTypeList);
		List<SellInFileDto> SellInFileDtoList = new ArrayList<>();

		fileTypeList.stream().forEach(ftype -> {
			List<SellInFile> sellInFileList = sellInFileRepository.getByFileType(ftype);
			SellInFileDto sellInFileDto = new SellInFileDto();
			sellInFileDto.setFileType(ftype);
			List<FileDetailsDto> fileDetailsDtoList = new ArrayList<>();
			sellInFileList.stream().forEach(obj -> {
				FileDetailsDto fileDetailsDto = new FileDetailsDto();
				fileDetailsDto.setCountryName(obj.getCountryName());
				fileDetailsDto.setFileId(obj.getFileId());
				fileDetailsDto.setFileName(obj.getFileName());
				fileDetailsDto.setFileSize(obj.getFileSize());
				fileDetailsDto.setStatus(obj.getStatus());
				fileDetailsDtoList.add(fileDetailsDto);
			});
			sellInFileDto.setActions(fileDetailsDtoList);
			SellInFileDtoList.add(sellInFileDto);
		});

		return SellInFileDtoList;
	}

}
