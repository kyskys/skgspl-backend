package skgspl.web.impl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "test", method = RequestMethod.GET, produces = "application/json")
	public String getGroup() {
		return "test";
	}

	
}
