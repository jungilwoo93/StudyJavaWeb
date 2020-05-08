package gacl.servlet.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
		downloadFileByOutputStream(response);//下载文件，通过OutputStream流
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
		//this.getServletContext().getRealPath("/download/1.JPG");
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
}
