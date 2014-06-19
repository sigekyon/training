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
 * �N���C�A���g�����̓��̓`�F�b�N���s���܂��B�܂��AuserInfo.txt��ǂݍ��݁A<br>
 * ID�����݂̍ő�l+1�Ŏ擾���A�N���C�A���g�����Ƃ��킹�Čٗp�ҏ���<br>
 * userInfo.txt�ɏ������݂܂��B
 * <br>�ŏI�X�V���F2014/6/19
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

			// �o�^���ꂽ�p�����[�^���擾
			String regName = request.getParameter("regName");
			String regAge = request.getParameter("regAge");
			// �V�KID��ݒ�
			String regId = ReadRegistInfo.getNewId();
			if(regId.equals("1000")){
				errMsg += "�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />";
			}			
			else if(inputCheck(regName, regAge)){// ���̓f�[�^�Ɍ�肪�������ꍇ�͂��̎|��\��������
			}
			if(!errMsg.equals("")){
				request.setAttribute("errMsg", errMsg);
				rd = request.getRequestDispatcher("/RegRegist.jsp");
				rd.forward(request, response);
				return ;
			}
			// ���͏���ݒ�
			RegistrantInfo regInfo = new RegistrantInfo();
			regInfo.setrId(regId);
			regInfo.setrName(regName);
			regInfo.setrAge(regAge);

			// �f�[�^����������
			WriteRegistInfo.regRegInfo(regInfo);

			// ���ʉ�ʂ֑J�ڂ��邽�߂̏���ݒ�
			request.setAttribute("regInfo", regInfo);
			rd = request.getRequestDispatcher("/RegistResult.jsp");

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
