package gacl.servlet.study;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo3
 */
@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		outputOneByOutputStream(response);//使用OutputStream输出1到客户端浏览器
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void outputOneByOutputStream(HttpServletResponse response) throws IOException{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write("使用OutputStream流输出数字1：".getBytes("UTF-8"));
		Integer i = 1 ;
		
		outputStream.write(i.toString().getBytes());
		//outputStream.write((1+"").getBytes());
		//si on utilise que outputStream.write(1);, le 1 ne peut pas être affiché
		//printwriter sera pareil
	}
}
