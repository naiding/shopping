package shopping.common;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import shopping.entity.ShoppingEntity;
import shopping.entity.User;

public class ResponseHelper {
	
	public static void createResponse(HttpServletResponse response, Collection<ShoppingEntity> entityList) {
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {
			for (ShoppingEntity entity : entityList) {
				JSONObject obj = entity.toJSONObject();
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray array = new JSONArray(list);
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			out.print(array);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createResponse(HttpServletResponse response, ShoppingEntity entity) {
		JSONObject obj = null;
		try {
			obj = entity.toJSONObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			out.print(obj);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createResponse(HttpServletResponse response, JSONObject jsonObject) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			out.print(jsonObject);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

