package mybaitsTest01.UserTest;

import java.io.IOException;
import java.io.InputStream;

import mybatis.mapper.User;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 第一节，简单的入门测试
 * @author Administrator
 *
 */

public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
/*		Reader reader = Resources.getResourceAsReader(resource); */
		//可以用classLoder来进行加载,因为在Src目录下，所以可以用  ，利用反射机制
	   InputStream stream =	Test.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		//映射sql的标识字符串
		String statement = "mybatis.mapper.orderMapper.getOrder";
		//执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);


	}

}
