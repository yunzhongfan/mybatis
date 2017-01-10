package mybatis.dao;

import java.util.List;


/**
 * ����ӿ���ʽ�ĵ���
 */
import java.util.Map;

import mybatis.mapper.User;

public interface UserMapper {
	
	User getUser(int id);
	
	int insert(User user);
	
	int delete(int id);
	
	int updateById(int id);
	
	Map<String, Integer> getUserCount(int sexid,int usercount);
	
	List<User> getVClassStudent(int id);
	
	

}
