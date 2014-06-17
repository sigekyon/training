package user.control;

import java.io.File;
import java.io.IOException;

import user.bean.RegistrantInfo;
import user.parts.ReadRegistInfo;
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
public class ProcDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcDel() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = null;

			// ‘ÎÛ‚Ì“o˜^Ò‚ğæ“¾
			HttpSession session = request.getSession(false);
			RegistrantInfo inputInfo = (RegistrantInfo)session.getAttribute("targetInfo");
			
			File file = new File("c:\\temp/userInfo.txt");

			// Œ»İ“o˜^‚³‚ê‚Ä‚¢‚é“o˜^Ò‚ğæ“¾
			ReadRegistInfo ru = new ReadRegistInfo();
			RegistrantInfo[] regInfo = ru.getReglist(file);
			
			// ƒf[ƒ^‚ğ‘‚«‚Ş
			WriteRegistInfo wu = new WriteRegistInfo();
			wu.delRegInfo(file, inputInfo, regInfo);

			// Œ‹‰Ê‰æ–Ê‚Ö‘JˆÚ‚·‚é‚½‚ß‚Ìî•ñ‚ğİ’è
			request.setAttribute("delInfo", inputInfo);
			rd = request.getRequestDispatcher("/DelResult.jsp");

			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errMsg", "ƒGƒ‰[‚ª”­¶‚µ‚Ü‚µ‚½B\‚µ–ó‚ ‚è‚Ü‚¹‚ñ‚ª‚à‚¤ˆê“xÅ‰‚©‚ç‚¨Šè‚¢‚µ‚Ü‚·B");
			HttpSession session = request.getSession(true);
		    session.invalidate();   
			RequestDispatcher rd = request.getRequestDispatcher(
					"/Login.jsp");
			rd.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}
