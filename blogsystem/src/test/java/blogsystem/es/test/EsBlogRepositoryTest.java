package blogsystem.es.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import blogsystem.domain.es.EsBlog;
import blogsystem.repository.es.EsBlogRepository;

/**
 * 
 **********************************************************
 * @作者: huisir
 * @日期: 2018年8月22日
 * @描述: 测试用例
 **********************************************************
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
	
	@Autowired
	private EsBlogRepository esBlogRepository;
	
	@Before
	public void init(){
		//清除所有
		esBlogRepository.deleteAll();
		esBlogRepository.save(new EsBlog(
				"wocao1","wocao1","wocao1"));
		esBlogRepository.save(new EsBlog(
				"wocao6","wocao6","wocao6"));
		esBlogRepository.save(new EsBlog(
				"wocao7","wocao7","wocao7"));
	}
	
	
	@Test
	public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
		Pageable pageable = new PageRequest(0, 20);
		Page<EsBlog> result = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining("wo", "woca", "wocao1", pageable);
		
		System.out.println(result.getSize());
		result.getContent().forEach( e ->System.out.println(e.toString()));
	}

}
