package propets.service.convertertosearch;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface DispatcherToSearch extends Sink {
	
	String LOST_SEARCH = "lostsearch";
	
	String FOUND_SEARCH = "foundsearch";
	
	@Output(LOST_SEARCH)
	MessageChannel lostsearch();
	
	@Output(FOUND_SEARCH)
	MessageChannel foundsearch();

}
