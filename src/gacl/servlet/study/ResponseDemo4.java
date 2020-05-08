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
	
	private void downloadFileWithNameChinese (HttpServletResponse response)
			throws FileNotFoundException, IOException {
		//1.获取要下载的文件的绝对路径
		String realPath = "C:\\Users\\liuyan\\Desktop\\截图.JPEG";
		//this.getServletContext().getRealPath("/download/1.JPG");
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
}
