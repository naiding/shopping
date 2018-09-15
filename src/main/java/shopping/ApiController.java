package shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopping.common.ResponseHelper;

@Controller
public class ApiController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void search(HttpServletRequest request, HttpServletResponse response) {
		ResponseHelper.createResponse(response);
	}
	
	
}