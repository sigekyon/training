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

			// �Ώۂ̓o�^�҂��擾
			HttpSession session = request.getSession(false);
			RegistrantInfo inputInfo = (RegistrantInfo)session.getAttribute("targetInfo");

			// ���ݓo�^����Ă���o�^�҂��擾
			RegistrantInfo[] regInfo = ReadRegistInfo.getReglist();
			
			// �f�[�^����������
			WriteRegistInfo.delRegInfo(inputInfo, regInfo);

			// ���ʉ�ʂ֑J�ڂ��邽�߂̏���ݒ�
			request.setAttribute("delInfo", inputInfo);
			rd = request.getRequestDispatcher("/DelResult.jsp");

			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errMsg", "�G���[���������܂����B�\���󂠂�܂��񂪂�����x�ŏ����炨�肢���܂��B");
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