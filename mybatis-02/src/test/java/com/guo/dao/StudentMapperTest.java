package com.guo.dao;

import com.guo.pojo.Student;
import com.guo.pojo.StudentVO;
import com.guo.pojo.User;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author guo
 * @date 2020/9/27
 */
public class StudentMapperTest {

	@Test
	public void getStudent() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.getStudent();
		for (Student student : studentList) {
			System.out.println(student);
		}
		sqlSession.close();
	}

	@Test
	public void getStudent2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.getStudent2();
		for (Student student : studentList) {
			System.out.println(student);
		}
		sqlSession.close();
	}

	@Test
	public void listStudentWithTeacher() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<StudentVO> studentVOS = studentMapper.listStudentWithTeacher();
		for (StudentVO studentVO : studentVOS) {
			System.out.println(studentVO);
		}
		sqlSession.close();
	}

	@Test
	public void listStudent() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.listStudent();
		for (Student student : students) {
			System.out.println(student);
		}
		sqlSession.close();
	}
}
