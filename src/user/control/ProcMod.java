	package user.control;

import java.io.IOException;

import user.bean.RegistrantInfo;
import user.parts.ReadRegistInfo;
import user.parts.RegInfCheck;
import user.parts.WriteRegistInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistList
 */
public class ProcMod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String errMsg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcMod() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = null;

			errMsg = "";

			// 対象の登録者を取得
			HttpSession session = request.getSession(false);
			RegistrantInfo inputInfo = (RegistrantInfo)session.getAttribute("targetInfo");
			
			// 変更されたパラメータを取得
			String regName = request.getParameter("regName");
			String regAge = request.getParameter("regAge");

			// 現在登録されている登録者を取得
			RegistrantInfo[] regInfo = ReadRegistInfo.getReglist();

			if (!inputCheck(regName, regAge)) {
				// 入力データに誤りがあった場合はその旨を表示させる
				request.setAttribute("errMsg", errMsg);
				rd = request.getRequestDispatcher("/ModRegist.jsp");
			} else {
				// 変更されたパラメータを設定
				inputInfo.setrName(regName);
				inputInfo.setrAge(regAge);
				
				// データを書き込む
				WriteRegistInfo.modRegInfo(inputInfo, regInfo);
				
				// 結果画面へ遷移するための情報を設定
				request.setAttribute("modInfo", inputInfo);
				rd = request.getRequestDispatcher("/ModResult.jsp");
			}
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "エラーが発生しました。申し訳ありませんがもう一度最初からお願いします。");
			HttpSession session = request.getSession(true);
		    session.invalidate();   
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}
	}

	private boolean inputCheck(String regName, String regAge) {
		RegInfCheck richk = new RegInfCheck();
		richk.checkName(regName);
		richk.checkAge(regAge);
		errMsg = richk.getErrMsg();
		if ("".equals(errMsg)) {
			return true;
		} else {
			return false;
		}
	}

}
