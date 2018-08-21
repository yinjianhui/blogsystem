package blogsystem.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import blogsystem.domain.User;

//@Service
public class UserRepositoryImpl /*implements UserRepository*/{
	
	private static AtomicLong count = new AtomicLong();
	private final ConcurrentHashMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();
	
	
	/*@Override
	public void deleteUser(long id) {
		this.userMap.remove(id);
	}
	
	@Override
	public User getUserByid(long id) {
		
		return this.userMap.get(id);
	}
	
	@Override
	public List<User> listUsers() {
		
		return new ArrayList<User>(this.userMap.values());
	}
	
	@SuppressWarnings("unused")
	@Override
	public User saveOrupdate(User user) {
		
		Long id = user.getId();
		if ( id <= 0) {
			id = count.incrementAndGet();
			user.setId(id);
		}
		
		this.userMap.put(id, user);
		
		return user;
	}*/
	
}
