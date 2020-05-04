package gacl.servlet.study;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextDemo1
 */
@WebServlet("/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     *WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用。
　　ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，可以通过ServletConfig.getServletContext方法获得ServletContext对象。
　　由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯。ServletContext对象通常也被称之为context域对象。
     */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = "xdp_gacl";
		/**
		 * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写
		 * servlet时，
		 * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
		 */
		ServletContext context = this.getServletConfig().getServletContext();
		//获得ServletContext对象
		context.setAttribute("data", data);  //将data存储到ServletContext对象中
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    /**
     * 先运行ServletContextDemo1，将数据data存储到ServletContext对象中，然后运行
     * ServletContextDemo2就可以从ServletContext对象中取出数据了，这样就实现了数据共享，
     */
}
