package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import myBaitsUtils.SessionUtilsTest;
import mybatis.mapper.User;

public class TestOneLevelCache {
	SqlSessionFactory session = SessionUtilsTest.getSession();

	/*
	 * 一级缓存: 也就Session级的缓存(默认开启)
	 */
	@Test
	public void testCache1() {
		SqlSession sqlSession = session.openSession(true);
		String statement = "mybatis.mapper.userMapper.getUser";
		 User user = sqlSession.selectOne(statement, 1);
		 System.out.println(user);
		
		 /*
		 * 一级缓存默认就会被使用
		 */
		 user = sqlSession.selectOne(statement, 1);
		 System.out.println(user);
		 // sqlSession.close();
		 /*
		 1. 必须是同一个Session,如果session对象已经close()过了就不可能用了
		 */
		 user = sqlSession.selectOne(statement, 1);
		 System.out.println(user);
		
		 /*
		 2. 查询条件是一样的
		 */
		 user = sqlSession.selectOne(statement, 2);
		 System.out.println(user);
		
		 /*
		 3. 没有执行过session.clearCache()清理缓存
		 如果session没有关闭则，再次执行相同的查询条件，查询还会在查询一次数据库！
		 如果session呗close掉则后面的查询无法进行查询
		 */
		 sqlSession.clearCache();
		 user = sqlSession.selectOne(statement, 2);
		 System.out.println(user);

		/*
		 * 4. 没有执行过增删改的操作(这些操作都会清理缓存)
		 */
		int i = sqlSession.update("mybatis.mapper.userMapper.updateById",
				new User(2, "user", 23));
		System.out.println(i);
		user = sqlSession.selectOne(statement, 2);
		System.out.println(user);


	}
	
	
	 /*
	      * 测试二级缓存
	      * 使用两个不同的SqlSession对象去执行相同查询条件的查询，第二次查询时不会再发送SQL语句，而是直接从缓存中取出数据
	      */
	     @Test
	     public void testCache2() {
		String statement = "mybatis.mapper.userMapper.getUser";
		// 开启两个不同的SqlSession
		SqlSession sqlsession1 = session.openSession();
		SqlSession sqlsession2 = session.openSession(); 
		// 使用二级缓存时，User类必须实现一个Serializable接口===>
		// User implements Serializable
		User user = sqlsession1.selectOne(statement, 1);
		sqlsession1.commit();// 不懂为啥，这个地方一定要提交事务之后二级缓存才会起作用，如果不提交失误会执行会在数据库中查询两次，查询失败
		System.out.println("user=" + user);

		// 由于使用的是两个不同的SqlSession对象，所以即使查询条件相同，一级缓存也不会开启使用
		user = sqlsession2.selectOne(statement, 1);
		// session2.commit();
		System.out.println("user2=" + user);
	     }

}
