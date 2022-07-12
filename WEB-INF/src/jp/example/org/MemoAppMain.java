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

		// -- ここから -- DBからメモ一覧を抽出
		List<Memo> memoList = new ArrayList<Memo>();
		try {
			memoList = new DisplayDAO().display();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("memoList", memoList);
		// -- ここまで --

		String view = "/WEB-INF/jsp/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String text = request.getParameter("text");

		// -- ここから -- DBからメモ一覧を抽出
		List<Memo> memoList = new ArrayList<Memo>();
		try {
			// -- ここでDBの保存処理 --
			new InsertDAO().insert(title, text);

			memoList = new DisplayDAO().display();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("memoList", memoList);
		// -- ここまで --

		response.sendRedirect(".");
	}
}
