package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myBaitsUtils.SessionUtilsTest;
import mybatis.mapper.Classes;
import mybatis.mapper.ClassesOne;
import mybatis.mapper.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test1 {
	SqlSessionFactory session = SessionUtilsTest.getSession();

	@Test
	public void queryTest() {
		SqlSession sqlsession = session.openSession();
		String statement = "mybatis.mapper.userMapper.getUser";// 映射sql的标识字符串
		User user = sqlsession.selectOne(statement, 1);
		sqlsession.close();
		System.out.println(user.toString());
	}

	@Test
	public void insertTest() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.userMapper.insert";
		User user = new User();
		user.setAge(123);
		user.setId(11);
		user.setName("张三他爸");
		int i = sqlSession.insert(statement, user);
		sqlSession.close();
		System.out.println(i);
	}

	@Test
	public void updateTest() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.userMapper.updateById";
		User user = new User();
		user.setId(10);
		user.setName("zhangsantaba");
		int i = sqlSession.update(statement, user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(i);
	}

	@Test
	public void deleteTest() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.userMapper.delete";
		int i = sqlSession.delete(statement, 10);
		sqlSession.close();
		System.out.println(i);
	}

	/**
	 * 一对一映射处理
	 */

	// 一对一关联查询，使用嵌套查询来处理映射处理结果的自封装数据查询（去除重复数据）
	@Test
	public void queryClassess() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.ClassesMapper.getClasses";
		Classes classess = sqlSession.selectOne(statement, 1);
		System.out.println(classess.toString());
		sqlSession.close();
	}

	// 一对一的封装查询
	@Test
	public void queryClassess2() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.ClassesMapper.getClasses2";
		Classes classess = sqlSession.selectOne(statement, 1);
		System.out.println(classess.toString());
		sqlSession.close();
	}

	// 一对多，查询一的一方
	@Test
	public void one2manyQuery() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.ClassesOneMapper.getoneClasses";
		ClassesOne classesOne = sqlSession.selectOne(statement, 1);
		System.out.println(classesOne.toString());
		sqlSession.close();
	}

	// 一对多，通过一的一方，查询出多的一方
	@Test
	public void one2manyQuery1() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.ClassesOneMapper.getmanyClasses";
		List<ClassesOne> classesOne = sqlSession.selectList(statement, 1);
		System.out.println(classesOne.toString());
		sqlSession.close();
	}

	@Test
	public void one2manyQuery2() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.ClassesOneMapper.getClasses2";
		ClassesOne classesOne = sqlSession.selectOne(statement, 1);
		System.out.println(classesOne.toString());
		sqlSession.close();
	}

	// mybatis调用存储过程
	@Test
	public void testGetUserCount() {
		SqlSession sqlSession = session.openSession();
		String statement = "mybatis.mapper.userMapper.getUserCount";// 映射sql的标识字符
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", -1);
		sqlSession.selectOne(statement, parameterMap);
		Integer result = parameterMap.get("usercount");
		System.out.println(result);
		sqlSession.close();

	}

}
