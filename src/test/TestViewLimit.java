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
 * ��ҳ��ѯ����ͼ��ѯ����
 * @author Administrator
 *
 */

public class TestViewLimit {
	SqlSessionFactory session = SessionUtilsTest.getSession();
	
	
	@Test
	public void testView(){
		SqlSession sqlSession = session.openSession();
		//����ͨ��mapper�ӿڵķ�ʽ���ã�����sqlSession.getMapper(UserMapper.class);
		//����ͨ�� statement �ķ�ʽ������������ sqlSession.*��������ʽ
		//String statement="mybatis.mapper.userMapper.getVClassStudent";
		UserMapper list=	sqlSession.getMapper(UserMapper.class);
		//������ͼ
		List<User> listuserList=	list.getVClassStudent(1);
		System.out.println(listuserList);
		
		
	}

}
