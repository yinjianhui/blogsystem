package blogsystem.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import blogsystem.domain.User;
/**
 **********************************************************
 * @作者: huisir
 * @日期: 2018年8月12日
 **********************************************************
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * 根据用户姓名分页查询用户列表
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<User> findByNameLike(String name, Pageable pageable);
	
	/**
	 * 根据用户账号查询用户
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 根据名称列表查询用户列表
	 * @param usernames
	 * @return
	 */
	List<User> findByUsernameIn(Collection<String> usernames);

	void deleteById(Long id);
	
	Optional<User> findById(Long id);
	
}
