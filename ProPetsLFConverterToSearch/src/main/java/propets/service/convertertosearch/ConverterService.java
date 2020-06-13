package propets.service.convertertosearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propets.dao.convertertosearch.FoundToSearchRepository;
import propets.dao.convertertosearch.LostToSearchRepository;

@Service
public class ConverterService {

	@Autowired
	FoundToSearchRepository foundRepository;
	@Autowired
	LostToSearchRepository lostRepository;

	public void deletePost(String id) {
		foundRepository.deleteById(id);
		lostRepository.deleteById(id);
	}

//	//test
//	public void save() {
//		FoundToSearch test = FoundToSearch.builder().id("321").type("dog").breed("dvornyaga").sex("male")
//				.userLogin("alf").build();
//		foundRepository.save(test);
//		LostToSearch test2 = LostToSearch.builder().id("123").type("dog").breed("dvornyaga").sex("male")
//				.userLogin("alf").build();
//		lostRepository.save(test2);
//	}
//	//test
//	public void load() {
//		System.out.println(foundRepository.findById("321").get().getId());
//		System.out.println(lostRepository.findById("123").get().getId());
//	}
}
