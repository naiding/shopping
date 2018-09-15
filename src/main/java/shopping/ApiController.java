package shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopping.common.RpcHelper;

@Controller
public class ApiController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void getUser(HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject obj = new JSONObject();
		obj.put("status", "hello there");
		RpcHelper.writeResponse(response, obj);
	}
}