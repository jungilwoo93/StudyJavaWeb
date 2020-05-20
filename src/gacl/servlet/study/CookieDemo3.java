package gacl.servlet.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo3
 */
@WebServlet("/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 删除cookie
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//创建一个名字为lastAccessTime的cookie
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
        //将cookie的有效期设置为0，命令浏览器删除该cookie
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        //要想在cookie中存储中文，那么必须使用URLEncoder类里面的encode(String s, String enc)方法进行中文转码，
        /**
         * Cookie cookie = new Cookie("userName", URLEncoder.encode("孤傲苍狼", "UTF-8"));
			response.addCookie(cookie);
         */
        
        //在获取cookie中的中文数据时，再使用URLDecoder类里面的decode(String s, String enc)进行解码，
        /**
         * URLDecoder.decode(cookies[i].getValue(), "UTF-8")
         */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
