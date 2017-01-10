package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import myBaitsUtils.SessionUtilsTest;
import mybatis.mapper.User;

public class TestOneLevelCache {
	SqlSessionFactory session = SessionUtilsTest.getSession();

	/*
	 * һ������: Ҳ��Session���Ļ���(Ĭ�Ͽ���)
	 */
	@Test
	public void testCache1() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.userMapper.getUser";
		 User user = sqlSession.selectOne(statement, 1);
		 System.out.println(user);
		
		 /*
		 * һ������Ĭ�Ͼͻᱻʹ��
		 */
		 user = sqlSession.selectOne(statement, 1);
		 System.out.println(user);
		 // sqlSession.close();
		 /*
		 1. ������ͬһ��Session,���session�����Ѿ�close()���˾Ͳ���������
		 */
		 user = sqlSession.selectOne(statement, 1);
		 System.out.println(user);
		
		 /*
		 2. ��ѯ������һ����
		 */
		 user = sqlSession.selectOne(statement, 2);
		 System.out.println(user);
		
		 /*
		 3. û��ִ�й�session.clearCache()������
		 ���sessionû�йر����ٴ�ִ����ͬ�Ĳ�ѯ��������ѯ�����ڲ�ѯһ�����ݿ⣡
		 ���session��close�������Ĳ�ѯ�޷����в�ѯ
		 */
		 sqlSession.clearCache();
		 user = sqlSession.selectOne(statement, 2);
		 System.out.println(user);

		/*
		 * 4. û��ִ�й���ɾ�ĵĲ���(��Щ��������������)
		 */
		int i = sqlSession.update("mybatis.mapper.userMapper.updateById",
				new User(2, "user", 23));
		System.out.println(i);
		user = sqlSession.selectOne(statement, 2);
		System.out.println(user);


	}
	
	
	 /*
	      * ���Զ�������
	      * ʹ��������ͬ��SqlSession����ȥִ����ͬ��ѯ�����Ĳ�ѯ���ڶ��β�ѯʱ�����ٷ���SQL��䣬����ֱ�Ӵӻ�����ȡ������
	      */
	     @Test
	     public void testCache2() {
		String statement = "mybatis.mapper.userMapper.getUser";
		// ����������ͬ��SqlSession
		SqlSession sqlsession1 = session.openSession();
		SqlSession sqlsession2 = session.openSession(); 
		// ʹ�ö�������ʱ��User�����ʵ��һ��Serializable�ӿ�===>
		// User implements Serializable
		User user = sqlsession1.selectOne(statement, 1);
		sqlsession1.commit();// ����Ϊɶ������ط�һ��Ҫ�ύ����֮���������Ż������ã�������ύʧ���ִ�л������ݿ��в�ѯ���Σ���ѯʧ��
		System.out.println("user=" + user);

		// ����ʹ�õ���������ͬ��SqlSession�������Լ�ʹ��ѯ������ͬ��һ������Ҳ���Ὺ��ʹ��
		user = sqlsession2.selectOne(statement, 1);
		// session2.commit();
		System.out.println("user2=" + user);
	     }

}
