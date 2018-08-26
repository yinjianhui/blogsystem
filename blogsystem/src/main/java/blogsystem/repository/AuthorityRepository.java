package blogsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blogsystem.domain.Authority;
/**
 * 
 **********************************************************
 * @作者: huisir
 * @日期: 2018年8月26日
 * @描述:
 **********************************************************
 
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
