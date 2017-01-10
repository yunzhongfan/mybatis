package test;

import java.util.List;
import java.util.Map;

import myBaitsUtils.SessionUtilsTest;
import mybatis.dao.UserMapper;
import mybatis.mapper.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;



/**
 * 分页查询、视图查询测试
 * @author Administrator
 *
 */

public class TestViewLimit {
	SqlSessionFactory session = SessionUtilsTest.getSession();
	
	
	@Test
	public void testView(){
		SqlSession sqlSession = session.openSession();
		//若是通过mapper接口的方式调用，则用sqlSession.getMapper(UserMapper.class);
		//若是通过 statement 的方式调用则这里用 sqlSession.*的其他方式
		//String statement="mybatis.mapper.userMapper.getVClassStudent";
		UserMapper list=	sqlSession.getMapper(UserMapper.class);
		//调用试图
		List<User> listuserList=	list.getVClassStudent(1);
		System.out.println(listuserList);
		
		
	}

}
