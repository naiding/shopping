package shopping.common;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class RpcHelper {
	
	public static void writeResponse(HttpServletResponse response, JSONObject jsonObject) {
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
