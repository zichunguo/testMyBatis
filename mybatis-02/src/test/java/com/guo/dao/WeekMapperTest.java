package com.guo.dao;

import com.guo.pojo.Week;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author guo
 * @date 2020/10/1
 */
public class WeekMapperTest {

	@Test
	public void listWeek() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		WeekMapper mapper = sqlSession.getMapper(WeekMapper.class);
		List<Week> weeks = mapper.listWeek();
		for (Week week : weeks) {
			System.out.println(week);
		}
		sqlSession.close();
	}

	@Test
	public void listWeek2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		WeekMapper mapper = sqlSession.getMapper(WeekMapper.class);
		List<Week> weeks = mapper.listWeek2();
		for (Week week : weeks) {
			System.out.println(week);
		}
		sqlSession.close();
	}
}
