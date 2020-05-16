package gacl.servlet.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo4
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//下列代码，当客户端写中文时，服务器收到的就是乱码，因为客户端和服务器的编码不一致
		//String userName =  request.getParameter("userName");
		//System.out.println("userName: " + userName);
		/**
         * 客户端是以UTF-8编码传输数据到服务器端的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
         */
        request.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8的编码金星接收
        response.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8编码输出数据到客户端
		response.setContentType("text/html;charset=UTF-8");//设置客户端浏览器以UTF-8编码解析数据
        String userName = request.getParameter("userName");
        System.out.println("userName："+userName);
        response.getWriter().write(userName);
	}

}
