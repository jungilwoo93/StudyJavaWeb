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
		//用get也依旧会有中文乱码的问题，
		/**
		 * request.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8的编码金星接收
		
        response.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8编码输出数据到客户端
		response.setContentType("text/html;charset=UTF-8");//设置客户端浏览器以UTF-8编码解析数据
        String userName = request.getParameter("name");
        System.out.println("name："+userName);//显示不出中文
        response.getWriter().write(userName);//在网页显示出中文*/
        
        //对于以get方式传输的数据，request即使设置了以指定的编码接收数据也是无效的，默认的还是使用ISO8859-1这个字符编码来接收数据
		String name = request.getParameter("name");//接收数据
        name =new String(name.getBytes("ISO8859-1"), "UTF-8") ;//获取request对象以ISO8859-1字符编码接收到的原始数据的字节数组，然后通过字节数组以指定的编码构建字符串，解决乱码问题
        System.out.println("name："+name);
        response.getWriter().write(name);//在网页显示出中文 
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
        System.out.println("userName："+userName); // 依旧显示不出中文
        response.getWriter().write(userName); //在网页显示了中文
	}

}
