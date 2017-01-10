package myBaitsUtils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sessionUtils {
   public  static SqlSessionFactory  getSessionFactory(){
	InputStream stream =   sessionUtils.class.getClassLoader().getResourceAsStream("conf.xml");
	 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
	return sqlSessionFactory;
	   
	   
   }
}
