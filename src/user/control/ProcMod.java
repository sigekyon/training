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

			// �Ώۂ̓o�^�҂��擾
			HttpSession session = request.getSession(false);
			RegistrantInfo inputInfo = (RegistrantInfo)session.getAttribute("targetInfo");
			
			// �ύX���ꂽ�p�����[�^���擾
			String regName = request.getParameter("regName");
			String regAge = request.getParameter("regAge");

			// ���ݓo�^����Ă���o�^�҂��擾
			RegistrantInfo[] regInfo = ReadRegistInfo.getReglist();

			if (!inputCheck(regName, regAge)) {
				// ���̓f�[�^�Ɍ�肪�������ꍇ�͂��̎|��\��������
				request.setAttribute("errMsg", errMsg);
				rd = request.getRequestDispatcher("/ModRegist.jsp");
			} else {
				// �ύX���ꂽ�p�����[�^��ݒ�
				inputInfo.setrName(regName);
				inputInfo.setrAge(regAge);
				
				// �f�[�^����������
				WriteRegistInfo.modRegInfo(inputInfo, regInfo);
				
				// ���ʉ�ʂ֑J�ڂ��邽�߂̏���ݒ�
				request.setAttribute("modInfo", inputInfo);
				rd = request.getRequestDispatcher("/ModResult.jsp");
			}
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "�G���[���������܂����B�\���󂠂�܂��񂪂�����x�ŏ����炨�肢���܂��B");
			HttpSession session = request.getSession(true);
		    session.invalidate();   
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
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