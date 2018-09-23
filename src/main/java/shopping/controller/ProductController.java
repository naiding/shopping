package shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopping.common.RpcHelper;
import shopping.entity.Product;
import shopping.service.ProductService;

@Controller
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@RequestMapping(value = "/{product_id}", method = RequestMethod.GET)
	public void login(@PathVariable(value = "product_id") int productId,
			HttpServletRequest request, HttpServletResponse response) {

		JSONObject obj = new JSONObject();
		Product product = service.getProduct(productId);
		if (product != null) {
			obj.put("status", "ok");
			obj.put("user", product.toJSONObject());
		} else {
			obj.put("status", "fail");
		}
		
		RpcHelper.writeResponse(response, obj);
	}
}