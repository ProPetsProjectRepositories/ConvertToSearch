package propets.controller.convertertosearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propets.service.convertertosearch.ConverterService;

@RestController
@CrossOrigin("*")
@RequestMapping("/{lang}/v1")
public class ConverterController {
	
	@Autowired
	ConverterService service;
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable String id) {
		service.deletePost(id);
	}
//	//test
//	@GetMapping("/test")
//	public void save() {
//		service.save();
//	}
//	//test
//	@GetMapping("/load")
//	public void load() {
//		service.load();
//	}

}
