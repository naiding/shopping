package shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopping.common.ResponseHelper;
import shopping.entity.ShoppingEntity;
import shopping.entity.User;

@Controller
public class ApiController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void search(HttpServletRequest request, HttpServletResponse response) {
		ShoppingEntity entity = new User("Naiding", "Zhou");
		ResponseHelper.createResponse(response, entity);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public void getUser(HttpServletRequest request, HttpServletResponse response) {
		User user = new User("Naiding", "Zhou");
		ResponseHelper.createResponse(response, user.toJSONObject());
	}
}