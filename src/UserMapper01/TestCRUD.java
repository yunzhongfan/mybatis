package UserMapper01;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCRUD {
	
	/**
	 * 第二节基于注解的测试
	 */
	@Test
    public void  selectAllMapperTest(){
		SqlSession session =myBaitsUtils.sessionUtils.getSessionFactory().openSession(true);
		List<User> list = session.getMapper(UserMapper.class).selectAllUser();
		session.close();
		System.out.println(list);
    	
    }
	
	
	
}
