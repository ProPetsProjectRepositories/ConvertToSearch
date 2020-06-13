package propets.dao.convertertosearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import propets.model.convertertosearch.LostToSearch;

public interface LostToSearchRepository extends ElasticsearchRepository<LostToSearch, String> {

}
