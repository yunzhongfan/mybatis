package mybaitsTest01.UserTest;

import java.io.IOException;
import java.io.InputStream;

import mybatis.mapper.User;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ��һ�ڣ��򵥵����Ų���
 * @author Administrator
 *
 */

public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource = "conf.xml"; 
		//����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
/*		Reader reader = Resources.getResourceAsReader(resource); */
		//������classLoder�����м���,��Ϊ��SrcĿ¼�£����Կ�����  �����÷������
	   InputStream stream =	Test.class.getClassLoader().getResourceAsStream(resource);
		//����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		//������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		//ӳ��sql�ı�ʶ�ַ���
		String statement = "mybatis.mapper.orderMapper.getOrder";
		//ִ�в�ѯ����һ��Ψһuser�����sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);


	}

}
