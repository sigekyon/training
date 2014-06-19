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
 * クライアント引数の入力チェックを行います。また、userInfo.txtを読み込み、<br>
 * IDを現在の最大値+1で取得し、クライアント引数とあわせて雇用者情報を<br>
 * userInfo.txtに書き込みます。
 * <br>最終更新日：2014/6/19
 * @version 1.0
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
			String regName = request.getParameter("regName");
			String regAge = request.getParameter("regAge");
			// 新規IDを設定
			String regId = ReadRegistInfo.getNewId();
			if(regId.equals("1000")){
				errMsg += "登録可能なID（999）を超えています。管理者に問い合わせてください。<br />";
			}			
			else if(inputCheck(regName, regAge)){// 入力データに誤りがあった場合はその旨を表示させる
			}
			if(!errMsg.equals("")){
				request.setAttribute("errMsg", errMsg);
				rd = request.getRequestDispatcher("/RegRegist.jsp");
				rd.forward(request, response);
				return ;
			}
			// 入力情報を設定
			RegistrantInfo regInfo = new RegistrantInfo();
			regInfo.setrId(regId);
			regInfo.setrName(regName);
			regInfo.setrAge(regAge);

			// データを書き込む
			WriteRegistInfo.regRegInfo(regInfo);

			// 結果画面へ遷移するための情報を設定
			request.setAttribute("regInfo", regInfo);
			rd = request.getRequestDispatcher("/RegistResult.jsp");

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

	private boolean inputCheck(String regName, String regAge) {

		errMsg = RegInfCheck.checkName(regName, errMsg);
		errMsg = RegInfCheck.checkAge(regAge, errMsg);
	
		if ("".equals(errMsg)) {
			return true;
		} else {
			return false;
		}
	}
}
