package com.guo.dao;

import com.guo.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

	Teacher getTeacher(@Param("tid") int tid);

	Teacher getTeacher2(@Param("tid") int tid);

	List<Teacher> listTeacher();

}
