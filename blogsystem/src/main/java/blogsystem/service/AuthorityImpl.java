package blogsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blogsystem.domain.Authority;
import blogsystem.repository.AuthorityRepository;

@Service
public class AuthorityImpl implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(Long id) {
		// TODO Auto-generated method stub
		return authorityRepository.findOne(id);
	}
	
	
	
}
