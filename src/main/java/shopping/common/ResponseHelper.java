package shopping.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class ResponseHelper {
	
	public static void createResponse(HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("status", "OK");
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
	
	public static void getResponse(HttpServletResponse response, JSONObject jsonObject) {
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

