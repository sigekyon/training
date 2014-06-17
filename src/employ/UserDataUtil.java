package employ;

import java.util.ArrayList;

public class UserDataUtil {

	public UserDataUtil() {
		// TODO Auto-generated constructor stub
	}

	public static void getUserData(ArrayList<UserData> UD) throws Exception {
		String fileName = "C:\\test\\table\\user.txt";
		ReadFile fru = new ReadFile(fileName);
		String str = new String();
		fru.FileOpen();
		while (true){
			str = fru.FileRead();
			if(str != null){
				String[] strAry = str.split(",");
				UserData ud1 = new UserData();
				ud1.setUser(strAry[0]);
				ud1.setPass(strAry[1]);
				UD.add(ud1);
			}else{
				break;
			}
		}
		fru.Fileclose();
	}

}
