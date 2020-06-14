package propets.service.convertertosearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;

import propets.dao.convertertosearch.FoundToSearchRepository;
import propets.dao.convertertosearch.LostToSearchRepository;
import propets.dto.convertertosearch.LostFoundDto;
import propets.dto.convertertosearch.LostFoundToSearchDTO;
import propets.model.convertertosearch.FoundToSearch;
import propets.model.convertertosearch.LostToSearch;

@EnableBinding(DispatcherToSearch.class)
public class FromLostFoundToSearch {

	@Autowired
	FoundToSearchRepository foundRepository;
	@Autowired
	LostToSearchRepository lostRepository;
	@Autowired
	DispatcherToSearch dispatcher;

	@StreamListener(DispatcherToSearch.INPUT)
	public void dispatcherToSearch(LostFoundDto lostFound) {

		if (lostFound.getTypePost()) {
			FoundToSearch foundSearch = convertToFoundDB(lostFound);
			foundRepository.save(foundSearch);
			dispatcher.foundsearch().send(MessageBuilder.withPayload(convertToSearch(foundSearch)).build());
			return;
		} else {
			LostToSearch lostSearch = convertToLostDB(lostFound);
			lostRepository.save(lostSearch);
			dispatcher.lostsearch().send(MessageBuilder.withPayload(convertToSearch(lostSearch)).build());
			return;
		}
	}

	private LostToSearch convertToLostDB(LostFoundDto lostFound) {
		return LostToSearch.builder().id(lostFound.getId()).type(lostFound.getType()).breed(lostFound.getBreed())
				.sex(lostFound.getSex()).userLogin(lostFound.getUserLogin()).address(lostFound.getAddress())
				.coordinates(lostFound.getCoordinates())
				.tags(lostFound.getTags().stream().reduce((a, b) -> a + " " + b).get()).build();
	}

	private FoundToSearch convertToFoundDB(LostFoundDto lostFound) {
		return FoundToSearch.builder().id(lostFound.getId()).type(lostFound.getType()).breed(lostFound.getBreed())
				.sex(lostFound.getSex()).userLogin(lostFound.getUserLogin()).address(lostFound.getAddress())
				.coordinates(lostFound.getCoordinates())
				.tags(lostFound.getTags().stream().reduce((a, b) -> a + " " + b).get()).build();
	}

	private LostFoundToSearchDTO convertToSearch(FoundToSearch lostFoundSearch) {
		return LostFoundToSearchDTO.builder().id(lostFoundSearch.getId()).type(lostFoundSearch.getType())
				.breed(lostFoundSearch.getBreed()).sex(lostFoundSearch.getSex())
				.userLogin(lostFoundSearch.getUserLogin()).address(lostFoundSearch.getAddress())
				.coordinates(lostFoundSearch.getCoordinates()).tags(lostFoundSearch.getTags()).build();
	}

	private LostFoundToSearchDTO convertToSearch(LostToSearch lostFoundSearch) {
		return LostFoundToSearchDTO.builder().id(lostFoundSearch.getId()).type(lostFoundSearch.getType())
				.breed(lostFoundSearch.getBreed()).sex(lostFoundSearch.getSex())
				.userLogin(lostFoundSearch.getUserLogin()).address(lostFoundSearch.getAddress())
				.coordinates(lostFoundSearch.getCoordinates()).tags(lostFoundSearch.getTags()).build();
	}

//	private <T> T convertToLostOrFoundDB(LostFoundDto lostFound) {
//		if (lostFound.getTypePost()) {
//			return (T) FoundToSearch.builder().id(lostFound.getId()).type(lostFound.getType()).breed(lostFound.getBreed())
//					.sex(lostFound.getSex()).userLogin(lostFound.getUserLogin()).address(lostFound.getAddress())
//					.coordinates(lostFound.getCoordinates())
//					.tags(lostFound.getTags().stream().reduce((a, b) -> a + " " + b).get()).build();
//		} else {
//			return (T) LostToSearch.builder().id(lostFound.getId()).type(lostFound.getType())
//					.breed(lostFound.getBreed()).sex(lostFound.getSex()).userLogin(lostFound.getUserLogin())
//					.address(lostFound.getAddress()).coordinates(lostFound.getCoordinates())
//					.tags(lostFound.getTags().stream().reduce((a, b) -> a + " " + b).get()).build();
//		}
//	}

}
