package blogsystem.repository;

import java.util.List;

import blogsystem.domain.User;
/**
 **********************************************************
 * @作者: huisir
 * @日期: 2018年8月12日
 **********************************************************
 */
public interface UserRepository {
	
	User saveOrupdate(User user);
	
	void deleteUser(long id);
	
	User getUserByid(long id);
	
	List<User> listUsers();

}
