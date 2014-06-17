package user.parts;

public class RegInfCheck {
	
	final static String CHECK_TYPE_FIX = "1";
	final static String CHECK_TYPE_WITHIN = "0";
	
	public RegInfCheck() {
	}
	
	public String checkId(String id, String msg) {
		
		StringBuffer errMsg = new StringBuffer(msg);
		
		// ���l�`�F�b�N
		if (!numberCheck(id)) {
			errMsg.append("ID�͐��l�œ��͂��Ă��������B<br />");
		}

		// �����`�F�b�N(�Œ�)
		if (!lengthCheck(id, CHECK_TYPE_FIX, 3)) {
			errMsg.append("ID��3��(�Œ�)�œ��͂��Ă��������B<br />");
		}

		// �͈̓`�F�b�N(001-999)
		if (!limitCheck(id, 1, 999)) {
			errMsg.append("ID��(001-999)�͈̔͂œ��͂��Ă��������B<br />");
		}
		
		return errMsg.toString();

	}

	public String checkName(String name, String msg) {

		StringBuffer errMsg = new StringBuffer(msg);

		// �����`�F�b�N(�ȓ�)
		if (!lengthCheck(name, CHECK_TYPE_WITHIN, 10)) {
			errMsg.append("���O��10���ȓ��œ��͂��Ă��������B<br />");
		}

		return errMsg.toString();
	}
	
	public String checkAge(String age, String msg) {

		StringBuffer errMsg = new StringBuffer(msg);
		
		// ���l�`�F�b�N
		if (!numberCheck(age)) {
			errMsg.append("�N��͐��l(���p)�œ��͂��Ă��������B<br />");
		}
		
		// �����`�F�b�N(�ȓ�)
		if (!lengthCheck(age, CHECK_TYPE_WITHIN, 3)) {
			errMsg.append("�N���3���ȓ��œ��͂��Ă��������B<br />");
		}
		
		// �͈̓`�F�b�N(16-60)
		if (!limitCheck(age, 16, 60)) {
			errMsg.append("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />");
		}
		
		return errMsg.toString();
	}

	private boolean numberCheck(final String str) {

		int intChk = 0; 
		for (int i = 0; i < str.length(); i++) { 
		
			char c = str.charAt(i);
			char c1 = '0'; 
			char c2 = '9'; 
			if (c < c1 || c > c2) {
				intChk = intChk + 1;
			} 
		}

		if (intChk == 0) {
			return true;
		} else {
			return false;
		} 
	}

	private boolean lengthCheck(final String str, final String type, final int dig) {
		
		if (str == null || str.length()==0) {
			return false;
		}
		
		if (CHECK_TYPE_FIX.equals(type)) {
			
			if (str.length() == dig ) {
				return true;
			} else { 
				return false;
			}
		} else {
			
			if (str.length() <= dig) {
				return true;
			} else { 
				return false;
			}
		}
	}
	
	private boolean limitCheck(final String val, final int min, final int max) {
		
		try {
			int num = Integer.parseInt(val);
		
			if ((min <= num) && (num <= max)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
