package user.control;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
public class ProcReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String errMsg;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcReg() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		
			request.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8"); 
			RequestDispatcher rd = null;

			errMsg = "";

			// 登録されたパラメータを取得
			String regId = request.getParameter("regId");
			String regName = request.getParameter("regName");
			String regAge = request.getParameter("regAge");
			
			if (!inputCheck(regId, regName, regAge)) {
				// 入力データに誤りがあった場合はその旨を表示させる
				request.setAttribute("errMsg", errMsg);
				rd = request.getRequestDispatcher("/RegRegist.jsp");
				rd.forward(request, response);
				return ;
			}
		
			File file = new File("c:\\temp/userInfo.txt");

			// 登録されているIDを取得
			ReadRegistInfo ru = new ReadRegistInfo();
			String[] idList = ru.getRegId(file);

			if (Arrays.asList(idList).contains(regId)) {
				errMsg = "入力されたIDは既に登録されています。<br />";
				request.setAttribute("errMsg", errMsg);
				rd = request.getRequestDispatcher("/RegRegist.jsp");
			} else {
				// 入力情報を設定
				RegistrantInfo regInfo = new RegistrantInfo();
				regInfo.setrId(regId);
				regInfo.setrName(regName);
				regInfo.setrAge(regAge);

				// データを書き込む
				WriteRegistInfo wu = new WriteRegistInfo();
				wu.regRegInfo(file, regInfo);

				// 結果画面へ遷移するための情報を設定
				request.setAttribute("regInfo", regInfo);
				rd = request.getRequestDispatcher("/RegistResult.jsp");
			}

			rd.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "エラーが発生しました。申し訳ありませんがもう一度最初からお願いします。");
			HttpSession session = request.getSession(true);
		    session.invalidate();   
			RequestDispatcher rd = request.getRequestDispatcher(
					"/Login.jsp");
			rd.forward(request, response);
		}
	}

	private boolean inputCheck(String regId, String regName, String regAge) {

		RegInfCheck regChk = new RegInfCheck();

		errMsg = regChk.checkId(regId, errMsg);
		errMsg = regChk.checkName(regName, errMsg);
		errMsg = regChk.checkAge(regAge, errMsg);
	
		if ("".equals(errMsg)) {
			return true;
		} else {
			return false;
		}
	}
}
