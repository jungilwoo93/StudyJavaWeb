package gacl.servlet.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo4
 */
@WebServlet("/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //demo pour télécharger les fichiers
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//downloadFileByOutputStream(response);//下载文件，通过OutputStream流
		downloadFileWithNameChinese(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void downloadFileByOutputStream(HttpServletResponse response)
	throws FileNotFoundException, IOException {
		//1.获取要下载的文件的绝对路径
		String realPath = "C:\\Users\\liuyan\\Desktop\\1.JPEG";
		//this.getServletContext().getRealPath("/download/1.JPG");用来获取服务器上的某个资源
		//2.获取要下载的文件名
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		//4.获取要下载的文件输入流
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		//5.创建数据缓冲区
		byte[] buffer = new byte[1024];
		//6.通过response对象获取OutputStream流
		OutputStream out = response.getOutputStream();
	    //7.将FileInputStream流写入到buffer缓冲区
		while ((len = in.read(buffer)) > 0) {
			//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
			out.write(buffer,0,len);
		}
		in.close();
	}
	
	private void downloadFileWithNameChinese (HttpServletResponse response)
			throws FileNotFoundException, IOException {
		//1.获取要下载的文件的绝对路径
		String realPath = "C:\\Users\\liuyan\\Desktop\\截图.JPEG";
		//this.getServletContext().getRealPath("/download/1.JPG");
		/**
		 * 2.forward
		* 客户端请求某个web资源，服务器跳转到另外一个web资源，这个forward也是给服务器用的，
		 * 那么这个"/"就是给服务器用的，所以此时"/"代表的就是web工程
		 * //this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		*/
		
		//2.获取要下载的文件名
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		//4.获取要下载的文件输入流
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		//5.创建数据缓冲区
		byte[] buffer = new byte[1024];
		//6.通过response对象获取OutputStream流
		OutputStream out = response.getOutputStream();
	    //7.将FileInputStream流写入到buffer缓冲区
		while ((len = in.read(buffer)) > 0) {
			//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
			out.write(buffer,0,len);
		}
		in.close();
		//文件下载注意事项：编写文件下载功能时推荐使用OutputStream流，避免使用PrintWriter流，因为OutputStream流是字节流，可以处理任意类型的数据，而PrintWriter流是字符流，只能处理字符数据，如果用字符流处理字节数据，会导致数据丢失。
		
	}
	
	//使用sendRedirect实现请求重定向
	//response.sendRedirect(request.getContextPath()+"/index.jsp");
	//使用request.getContextPath()代替"/项目名称
	
	//使用超链接跳转
	//<a href="${pageContext.request.contextPath}/index.jsp">跳转到首页</a>
	
	//.Form表单提交
	 //<form action="${pageContext.request.contextPath}/servlet/CheckServlet" method="post">
	 //         <input type="submit" value="提交">
	 //</form>
	
	
	/**response细节问题
	　　getOutputStream和getWriter方法分别用于得到输出二进制数据、输出文本数据的ServletOuputStream、Printwriter对象。
	　　getOutputStream和getWriter这两个方法互相排斥，调用了其中的任何一个方法后，就不能再调用另一方法。  
	　　Servlet程序向ServletOutputStream或PrintWriter对象中写入的数据将被Servlet引擎从response里面获取，Servlet引擎将这些数据当作响应消息的正文，然后再与响应状态行和各响应头组合后输出到客户端。
	　　Serlvet的service方法结束后，Servlet引擎将检查getWriter或getOutputStream方法返回的输出流对象是否已经调用过close方法，如果没有，Servlet引擎将调用close方法关闭该输出流对象。
	*/
}
