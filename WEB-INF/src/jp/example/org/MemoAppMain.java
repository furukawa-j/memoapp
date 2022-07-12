package jp.example.org;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Memo;
import dao.DisplayDAO;
import dao.InsertDAO;

@WebServlet("/")
public class MemoAppMain extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Memo>memoList=new ArrayList<Memo>();
		try {
			memoList=new DisplayDAO().display();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("memoList", memoList);

		String view = "/WEB-INF/jsp/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	 @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 String title=request.getParameter("title");
		 String text=request.getParameter("text");
	        System.out.println("title:" + title);
	        System.out.println("text: " + text);

	        // -- ここにDBへ保存処理 --
	        List<Memo>memoList=new ArrayList<Memo>();
			try {
				new InsertDAO().insert(title,text);
				memoList=new DisplayDAO().display();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("memoList", memoList);


	        response.sendRedirect(".");
	    }
}
