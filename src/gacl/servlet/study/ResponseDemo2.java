package gacl.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo2
 */
@WebServlet("/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //使用PrintWriter流输出中文   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		outputChineseByPrintWriter(response);//使用PrintWriter流输出中文
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void outputChineseByPrintWriter(HttpServletResponse response) throws IOException{
		 String data = "中国";
		//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		 response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
		 //PrintWriter out = response.getWriter();这句代码必须放在response.setCharacterEncoding("UTF-8");之后
		 //否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，浏览器显示的时候还是乱码
		 PrintWriter out = response.getWriter();//获取PrintWriter输出流
		 //多学一招：使用HTML语言里面的<meta>标签来控制浏览器行为，模拟通过设置响应头控制浏览器行为
		 //out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		 //等同于response.setHeader("content-type", "text/html;charset=UTF-8");
		 out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		 out.write(data);//使用PrintWriter流向客户端输出字符
		 //当需要向浏览器输出字符数据时，使用PrintWriter比较方便，省去了将字符转换成字节数组那一步。
	}
}
