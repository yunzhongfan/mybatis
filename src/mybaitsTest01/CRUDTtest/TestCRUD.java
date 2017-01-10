package mybaitsTest01.CRUDTtest;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 第二节基于简单入门的mybaits的增删改查
 * @author Administrator
 *
 */

public class TestCRUD {
	@Test
    public void  addTest(){
		SqlSession session =myBaitsUtils.sessionUtils.getSessionFactory().openSession();
		String statement = "mybaitsTest01.CRUDTtest.userMapper.addUser" ;
		
		User user = new User();
		user.setAge(15);
		user.setName("lilei");
		int  result  = session.insert(statement, user);	
		session.commit();
		session.close();
		System.out.println(result);
    	
    }
	
	@Test
    public void  deleteTest(){
		SqlSession session =myBaitsUtils.sessionUtils.getSessionFactory().openSession();
		String statement = "mybaitsTest01.CRUDTtest.userMapper.deleteUser" ;
		

		int  result  = session.delete(statement,6);
		session.commit();
		session.close();
		System.out.println(result);
    	
    }
	
	@Test
    public void  updateTest(){
		SqlSession session =myBaitsUtils.sessionUtils.getSessionFactory().openSession();
		String statement = "mybaitsTest01.CRUDTtest.userMapper.updateUser" ;
		User user = new User();
		user.setId(7);
		user.setAge(15);
		user.setName("lilei");
		int  result  = session.insert(statement, user);	
		session.commit();
		session.close();
		System.out.println(result);
    	
    }
	
	
	@Test
    public void  selectAllTest(){
		SqlSession session =myBaitsUtils.sessionUtils.getSessionFactory().openSession();
		String statement = "mybaitsTest01.CRUDTtest.userMapper.selectAll" ;
		List<User> list = session.selectList(statement);
		System.out.println(list);
    	
    }
	
	
}
