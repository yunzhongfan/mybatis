package myBaitsUtils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtilsTest {
	 private static SqlSessionFactory sqlSessionFactory;
	 private static Reader reader; 
	 static{
		 try{
	            reader    = Resources.getResourceAsReader("conf.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        }catch(Exception e){
	            e.printStackTrace();
	        }

		
	 }
	 public static SqlSessionFactory getSession(){
	        return sqlSessionFactory;
	    }
}
