package user.bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserAuth {

	public UserAuth() {
	}

	public boolean execute(UserInfo uInfo) throws IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream("c:\\temp/user.properties"));

		String tmpId = prop.getProperty("user.id");
		String[] id = tmpId.split(",");
		String tmpPass = prop.getProperty("user.pass");
		String[] pass = tmpPass.split(",");

		for (int i = 0; i < id.length; i++) {

			if (id[i].equals(uInfo.getUserName())
					&& pass[i].equals(uInfo.getUserPass())) {

				// ���[�U�ƃp�X���[�h����v���Ă����OK
				return true;
			}
		}

		return false;

	}

}
