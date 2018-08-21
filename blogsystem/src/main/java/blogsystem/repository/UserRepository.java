package blogsystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import blogsystem.domain.User;
/**
 **********************************************************
 * @作者: huisir
 * @日期: 2018年8月12日
 **********************************************************
 */
public interface UserRepository extends CrudRepository<User, Long>{
	
//	User saveOrupdate(User user);
//	
//	void deleteUser(long id);
//	
//	User getUserByid(long id);
//	
//	List<User> listUsers();

}
