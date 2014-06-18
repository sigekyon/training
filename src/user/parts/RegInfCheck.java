package user.parts;

public class RegInfCheck {
	
	final static String CHECK_TYPE_FIX = "1";
	final static String CHECK_TYPE_WITHIN = "0";
	
	public RegInfCheck() {
	}
	
	public static String checkName(String name, String msg) {

		StringBuffer errMsg = new StringBuffer(msg);

		// �����`�F�b�N(�ȓ�)
		if (!lengthCheck(name, CHECK_TYPE_WITHIN, 10)) {
			errMsg.append("���O��10���ȓ��œ��͂��Ă��������B<br />");
		}

		return errMsg.toString();
	}
	
	public static String checkAge(String age, String msg) {

		StringBuffer errMsg = new StringBuffer(msg);
		
		// ���l�`�F�b�N
		if (!numberCheck(age)) {
			errMsg.append("�N��͐��l(���p)�œ��͂��Ă��������B<br />");
		}
		
		// �͈̓`�F�b�N(16-60)
		if (!limitCheck(age, 16, 60)) {
			errMsg.append("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />");
		}
		
		return errMsg.toString();
	}

	private static boolean numberCheck(final String str) {

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

	private static boolean lengthCheck(final String str, final String type, final int dig) {
		
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
	
	private static boolean limitCheck(final String val, final int min, final int max) {
		
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
