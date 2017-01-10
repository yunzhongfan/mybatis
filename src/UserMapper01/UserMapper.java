package UserMapper01;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	
@Insert("insert into users(id, name) values(#{id},#{name})")	
 public  int addUser(User user);
  

@Delete("delete  from  users where id = #{id}")
 public   int deleteUser(int id);
 

@Update("update users set name = #{name}, age = #{age} where id = #{id}")
 public int updateUser(User user);
 
@Select("select * from users where id=#{id}")
 public User selectUser(int id );
 
@Select(" select * from  users")
 public  List<User> selectAllUser();

}
