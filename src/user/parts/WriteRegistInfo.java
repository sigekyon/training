package user.parts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import user.bean.RegistrantInfo;

public class WriteRegistInfo {
	
	final String infSprit = ",";

	public void regRegInfo(File file, RegistrantInfo regInfo) throws IOException {

		FileWriter fWriter = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fWriter));
		
		pw.println(regInfo.getrId() + infSprit 
				+ regInfo.getrName() + infSprit
				+ regInfo.getrAge());
		pw.close();
		
	}
	
	public void modRegInfo(File file, RegistrantInfo inputInfo,
			RegistrantInfo[] regInfo) throws IOException{

		int t = searchId(inputInfo.getrId(), regInfo);

		FileWriter fWriter = new FileWriter(file);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fWriter));

		for (int i = 0; i < regInfo.length; i++) {

			if (i == t) {
				pw.println(inputInfo.getrId() + infSprit + inputInfo.getrName()
						+ infSprit + inputInfo.getrAge());
			} else {
				pw.println(regInfo[i].getrId() + infSprit
						+ regInfo[i].getrName() + infSprit
						+ regInfo[i].getrAge());
			}
		}
		pw.close();		
	}
	
	public void delRegInfo(File file, RegistrantInfo inputInfo,
			RegistrantInfo[] regInfo) throws IOException {
		
		int t = searchId(inputInfo.getrId(), regInfo);
	
		FileWriter fWriter = new FileWriter(file);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fWriter));

		for (int i = 0; i < regInfo.length; i++) {

			if (i != t) {
				pw.println(regInfo[i].getrId() + infSprit
						+ regInfo[i].getrName() + infSprit
						+ regInfo[i].getrAge());
			}
		}

		pw.close();
	}

	private int searchId(String regId, RegistrantInfo[] regInfo) {

		int target_number = -1;

		if (regId == null) {
			return target_number;
		}

		for (int i = 0; i < regInfo.length; i++) {

			if (regId.equals(regInfo[i].getrId())) {
				target_number = i;
				break;
			}
		}

		return target_number;
	}

}