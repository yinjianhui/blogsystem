package blogsystem.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import blogsystem.domain.es.EsBlog;
/**
 * 
 **********************************************************
 * @作者: huisir
 * @日期: 2018年8月22日
 * @描述: es 资源库
 **********************************************************
 
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
	
	/**
	 * 分页 去重 模糊查询博客
	 * @param title
	 * @param summary
	 * @param content
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
