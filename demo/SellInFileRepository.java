package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellInFileRepository extends JpaRepository<SellInFile, Integer> {
	@Query("select distinct(fileType) from SellInFile where month=:m and year=:y")
	List<String> getUniqueFileTypeByMonthAndYear(@Param("m") int month, @Param("y") int year);

	List<SellInFile> getByFileType(String ftype);

}
