package shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopping.common.RpcHelper;
import shopping.entity.Product;
import shopping.entity.User;
import shopping.service.UserService;

@Controller
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@ModelAttribute User user,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		if (service.register(user)) {
			obj.put("status", "ok");
		} else {
			obj.put("status", "fail");
		}
		RpcHelper.writeResponse(response, obj);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestParam(value = "email") String email,
					  @RequestParam(value = "password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		Integer userId = service.login(email, password);
		if (userId != null) {
			obj.put("status", "ok");
			obj.put("user_id", userId.toString());
			HttpSession session = request.getSession();
            session.setAttribute("user_id", userId.toString());
            session.setMaxInactiveInterval(10 * 60);
		} else {
			response.setStatus(403);
			obj.put("status", "User does not exist");
		}
		RpcHelper.writeResponse(response, obj);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		HttpSession session = request.getSession(false);
        if (session == null) {
            response.setStatus(403);
            obj.put("status", "Session invalid");
        } else {
        		obj.put("status", "ok");
            obj.put("user_id", session.getAttribute("user_id"));
        }
        RpcHelper.writeResponse(response, obj);
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product, 
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		if (service.addProduct(product)) {
			obj.put("status", "ok");
		} else {
			obj.put("status", "fail");
		}
		RpcHelper.writeResponse(response, obj);
	}
	
	@RequestMapping(value = "/profile/{user_id}", method = RequestMethod.GET)
	public void profile(@PathVariable(value = "user_id") int userId,
			HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject obj = new JSONObject();
		HttpSession session = request.getSession(false);
        if (session == null || !session.getAttribute("user_id").equals(String.valueOf(userId))) {
            response.setStatus(403);
            obj.put("status", "Permission denied");
        } else {
    		User user = service.getProfile(userId);
    		if (user != null) {
    			obj.put("status", "ok");
    			obj.put("user", user.toJSONObject());
    		} else {
    			obj.put("status", "User does not exist");
    		}
        }
		RpcHelper.writeResponse(response, obj);
	}
}