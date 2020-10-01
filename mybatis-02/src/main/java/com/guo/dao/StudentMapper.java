package com.guo.dao;

import com.guo.pojo.Student;
import com.guo.pojo.StudentVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

	List<Student> getStudent();

	List<Student> getStudent2();

	List<StudentVO> listStudentWithTeacher();

//	@Select("select * from student")
	List<Student> listStudent();
}
