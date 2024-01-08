package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

@Mapper
public interface UserMapper {

	// input: parameters
	// output: x
	public void insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email,
			@Param("introduce") String introduce);

	public User selectLatestUser();

	// input: name
	// output: boolean(true:중복 false:중복아님)
	public boolean isDuplicationByName(String name);

}