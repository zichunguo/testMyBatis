package com.guo.dao;

import com.guo.pojo.Student;
import com.guo.pojo.Teacher;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author guo
 * @date 2020/9/27
 */
public class TeacherMapperTest {

	@Test
	public void getTeacher() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = teacherMapper.getTeacher(1);
		System.out.println(teacher);
		sqlSession.close();
	}

	@Test
	public void getTeacher2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = teacherMapper.getTeacher2(1);
		System.out.println(teacher);
		sqlSession.close();
	}

	@Test
	public void listTeacher() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		List<Teacher> teachers = teacherMapper.listTeacher();
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
		sqlSession.close();
	}
}
