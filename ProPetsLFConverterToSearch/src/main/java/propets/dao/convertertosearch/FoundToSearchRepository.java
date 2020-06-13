package propets.dao.convertertosearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import propets.model.convertertosearch.FoundToSearch;

public interface FoundToSearchRepository extends ElasticsearchRepository<FoundToSearch, String> {

}
