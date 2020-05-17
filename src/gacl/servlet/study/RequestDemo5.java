package gacl.servlet.study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo5
 */
@WebServlet("/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data="大家好";
        /**
         * 将数据存放到request对象中,此时把request对象当作一个Map容器来使用
         */
        request.setAttribute("data", data);
        //客户端访问RequestDemo06这个Servlet后，RequestDemo06通知服务器将请求转发(forward)到test.jsp页面进行处理
        //request.getRequestDispatcher("/test.jsp").forward(request, response);
        RequestDispatcher requestDispatcher= this.getServletContext().getRequestDispatcher("/index4.jsp");
        requestDispatcher.forward(request,response);
        //在浏览器进去RequestDemo5，RequestDemo5将请求转发到index4.jsp页面
        /**
         * request对象作为一个域对象(Map容器)使用时，主要是通过以下的四个方法来操作

setAttribute(String name,Object o)方法，将数据作为request对象的一个属性存放到request对象中，例如：request.setAttribute("data", data);
getAttribute(String name)方法，获取request对象的name属性的属性值，例如：request.getAttribute("data")
removeAttribute(String name)方法，移除request对象的name属性，例如：request.removeAttribute("data")
getAttributeNames方法，获取request对象的所有属性名，返回的是一个，例如：Enumeration<String> attrNames = request.getAttributeNames();
         */
	}
	
	/**
	 * 请求重定向和请求转发的区别
　　一个web资源收到客户端请求后，通知服务器去调用另外一个web资源进行处理，称之为请求转发/307。
　　一个web资源收到客户端请求后，通知浏览器去访问另外一个web资源进行处理，称之为请求重定向/302。
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
